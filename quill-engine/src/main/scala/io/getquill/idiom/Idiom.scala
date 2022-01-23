package io.getquill.idiom

import io.getquill.ast._
import io.getquill.NamingStrategy
import io.getquill.context.Capabilities

trait Idiom extends Capabilities {

  def emptySetContainsToken(field: Token): Token = StringToken("FALSE")

  def defaultAutoGeneratedToken(field: Token): Token = StringToken("DEFAULT VALUES")

  def liftingPlaceholder(index: Int): String

  def translate(ast: Ast)(implicit naming: NamingStrategy): (Ast, Statement)

  def translateCached(ast: Ast)(implicit naming: NamingStrategy): (Ast, Statement)

  def format(queryString: String): String = queryString

  def prepareForProbing(string: String): String
}