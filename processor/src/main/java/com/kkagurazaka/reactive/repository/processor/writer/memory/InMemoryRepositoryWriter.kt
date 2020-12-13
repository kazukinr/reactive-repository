package com.kkagurazaka.reactive.repository.processor.writer.memory

import com.kkagurazaka.reactive.repository.processor.ProcessingContext
import com.kkagurazaka.reactive.repository.processor.definition.MethodDefinition
import com.kkagurazaka.reactive.repository.processor.definition.memory.InMemoryRepositoryDefinition
import com.kkagurazaka.reactive.repository.processor.exception.ProcessingException
import com.kkagurazaka.reactive.repository.processor.writer.RepositoryWriter
import com.kkagurazaka.reactive.repository.processor.writer.Rx3FieldSpecsBuilder
import com.kkagurazaka.reactive.repository.processor.writer.Rx3MethodSpecBuilder
import com.squareup.javapoet.*
import javax.lang.model.element.Modifier

class InMemoryRepositoryWriter(context: ProcessingContext, definition: InMemoryRepositoryDefinition) :
    RepositoryWriter<InMemoryRepositoryDefinition>(context, definition) {

    override fun TypeSpec.Builder.setup(): TypeSpec.Builder {
        val entityDefinition = definition.entityDefinition
        val entityClassName = entityDefinition.className
        val createDefault = entityDefinition.hasEmptyConstructor
        val hasRx3Methods = definition.hasRx3Methods

        val constructor = buildConstructorMethodSpec(entityClassName, createDefault, hasRx3Methods)
        if (constructor != null) {
            addMethod(constructor)
        }

        addMethods(definition.methodDefinitions.mapNotNull {
            InMemoryNonReactiveMethodSpecBuilder.build(it, hasRx3Methods)
        })

        if (hasRx3Methods) {
            addFields(Rx3FieldSpecsBuilder.build(entityDefinition))
            addMethods(definition.methodDefinitions.mapNotNull {
                Rx3MethodSpecBuilder.build(it, prepareStatement = null)
            })
        } else {
            addField(buildValueFieldSpec(entityClassName, createDefault))
        }

        return this
    }

    override fun verify() {
        if (definition.has<MethodDefinition.Type.NonNullGetter>() &&
            definition.has<MethodDefinition.Type.NullableSetter>()
        ) {
            throw ProcessingException(
                "@InMemoryRepository does not accept both of @NonNull getter and @Nullable setter",
                definition.element
            )
        }

        if (definition.hasRx3Methods && definition.has<MethodDefinition.Type.NullableSetter>()) {
            throw ProcessingException(
                "@InMemoryRepository does not accept @Nullable setter with RxJava3 integration",
                definition.element
            )
        }
    }

    private fun buildConstructorMethodSpec(
        entityClassName: ClassName,
        createDefault: Boolean,
        hasRx3Methods: Boolean
    ): MethodSpec? =
        if (hasRx3Methods) {
            MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .apply {
                    val createDefaultCode = if (createDefault) {
                        CodeBlock.builder().add("new \$T()", entityClassName).build()
                    } else {
                        null
                    }
                    Rx3FieldSpecsBuilder.buildInitializeStatement(createDefaultCode)
                        .forEach { addCode(it) }
                }
                .build()
        } else {
            null
        }

    private fun buildValueFieldSpec(entityClassName: ClassName, createDefault: Boolean): FieldSpec =
        FieldSpec
            .builder(entityClassName, "value", Modifier.PRIVATE)
            .apply {
                if (createDefault) {
                    initializer("new \$T()", entityClassName)
                } else {
                    initializer("null")
                }
            }
            .build()
}
