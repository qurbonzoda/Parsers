package generated;

import java.io.InputStream;

public final class GeneratedParser {
    private GeneratedLexer lex;

    public GeneratedParser(InputStream inputStream) {
        lex = new GeneratedLexer(inputStream);
        lex.nextToken();
    }

	public String print() {
		String value;
		switch (lex.curToken().name) {
			case "'print'":
				{
				if (!"'print'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected 'print', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e=				expression();

				{ value = String.format("writeln(%s);",  e);}

				}
				break;
			default:
				throw new IllegalArgumentException("unexpected token " + lex.curToken().name);
		}
		return value;
	}

	public String expression() {
		String value;
		switch (lex.curToken().name) {
			case "'+'":
				{
				if (!"'+'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '+', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("(%s + %s)",  e1,  e2);}

				}
				break;
			case "'-'":
				{
				if (!"'-'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '-', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("(%s - %s)",  e1,  e2);}

				}
				break;
			case "'*'":
				{
				if (!"'*'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '*', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("%s * %s",  e1,  e2);}

				}
				break;
			case "'/'":
				{
				if (!"'/'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '/', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("(%s / %s)",  e1,  e2);}

				}
				break;
			case "NUMBER":
				{
				String n=lex.curToken().text;
				if (!"NUMBER".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected NUMBER, found " + lex.curToken().name);
				}
				lex.nextToken();

				{ value =  n;}

				}
				break;
			case "NAME":
				{
				String var=lex.curToken().text;
				if (!"NAME".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected NAME, found " + lex.curToken().name);
				}
				lex.nextToken();

				{ value =  var;}

				}
				break;
			case "BOOL":
				{
				String b=lex.curToken().text;
				if (!"BOOL".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected BOOL, found " + lex.curToken().name);
				}
				lex.nextToken();

				{ value =  b;}

				}
				break;
			case "'and'":
				{
				if (!"'and'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected 'and', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("%s and %s",  e1,  e2);}

				}
				break;
			case "'or'":
				{
				if (!"'or'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected 'or', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("(%s or %s)",  e1,  e2);}

				}
				break;
			case "'not'":
				{
				if (!"'not'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected 'not', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e=				expression();

				{ value = String.format("not %s",  e);}

				}
				break;
			case "'<'":
				{
				if (!"'<'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '<', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("%s < %s",  e1,  e2);}

				}
				break;
			case "'>'":
				{
				if (!"'>'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '>', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("%s > %s",  e1,  e2);}

				}
				break;
			case "'>='":
				{
				if (!"'>='".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '>=', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("%s >= %s",  e1,  e2);}

				}
				break;
			case "'<='":
				{
				if (!"'<='".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '<=', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("%s <= %s",  e1,  e2);}

				}
				break;
			case "'=='":
				{
				if (!"'=='".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '==', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("%s == %s",  e1,  e2);}

				}
				break;
			case "'!='":
				{
				if (!"'!='".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '!=', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e1=				expression();

				String e2=				expression();

				{ value = String.format("%s != %s",  e1,  e2);}

				}
				break;
			default:
				throw new IllegalArgumentException("unexpected token " + lex.curToken().name);
		}
		return value;
	}

	public String conditional() {
		String value;
		switch (lex.curToken().name) {
			case "'if'":
				{
				if (!"'if'".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected 'if', found " + lex.curToken().name);
				}
				lex.nextToken();

				String e=				expression();

				String act=				action();

				{ value = String.format("if (%s) then\n\t%s",  e,  act);}

				}
				break;
			default:
				throw new IllegalArgumentException("unexpected token " + lex.curToken().name);
		}
		return value;
	}

	public String start() {
		String value;
		switch (lex.curToken().name) {
			case "'if'":
			case "'='":
			case "'print'":
				{
				String p=				program();

				{ value = String.format("begin%s\nend.",  p);}

				}
				break;
			default:
				{
				String p=				program();

				{ value = String.format("begin%s\nend.",  p);}

				}
		}
		return value;
	}

	public String action() {
		String value = "\t";
		switch (lex.curToken().name) {
			case "'='":
				{
				String a=				assign();

				{ value +=  a;}

				}
				break;
			case "'print'":
				{
				String p=				print();

				{ value +=  p;}

				}
				break;
			case "'if'":
				{
				String e=				conditional();

				{ value +=  e;}

				}
				break;
			default:
				throw new IllegalArgumentException("unexpected token " + lex.curToken().name);
		}
		return value;
	}

	public String program() {
		String value = "";
		switch (lex.curToken().name) {
			case "'if'":
			case "'='":
			case "'print'":
				{
				String np=				nonEmptyProgram();

				{ value += String.format("\n%s",  np);}

				}
				break;
			default:
				{
				}
		}
		return value;
	}

	public String nonEmptyProgram() {
		String value = "";
		switch (lex.curToken().name) {
			case "'if'":
			case "'='":
			case "'print'":
				{
				String act=				action();

				String p=				program();

				{ value += String.format("\n%s\n%s",  act,  p);}

				}
				break;
			default:
				throw new IllegalArgumentException("unexpected token " + lex.curToken().name);
		}
		return value;
	}

	public String assign() {
		String value;
		switch (lex.curToken().name) {
			case "'='":
				{
				if (!"'='".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected '=', found " + lex.curToken().name);
				}
				lex.nextToken();

				String var=lex.curToken().text;
				if (!"NAME".equals(lex.curToken().name)) {
					throw new IllegalArgumentException("expected NAME, found " + lex.curToken().name);
				}
				lex.nextToken();

				String e=				expression();

				{ value = String.format("%s = %s;",  var,  e);}

				}
				break;
			default:
				throw new IllegalArgumentException("unexpected token " + lex.curToken().name);
		}
		return value;
	}


}