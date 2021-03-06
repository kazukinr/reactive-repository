package com.kkagurazaka.reactive.repository.processor.definition.prefs

import com.kkagurazaka.reactive.repository.processor.ProcessingContext
import com.kkagurazaka.reactive.repository.processor.tools.toLowerSnake
import com.squareup.javapoet.TypeName
import javax.lang.model.element.Element
import javax.lang.model.element.ExecutableElement

class SetterDefinition(
    context: ProcessingContext,
    element: Element,
    typeAdapter: TypeAdapterDefinition?
) : KeyDefinition(context, element, typeAdapter) {

    override val key: String = specifiedKey ?: name.removePrefix("set").toLowerSnake()

    override fun getTargetType(element: Element): TypeName =
        TypeName.get((element as ExecutableElement).parameters.first().asType())
}
