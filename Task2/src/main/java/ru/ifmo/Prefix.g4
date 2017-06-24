grammar Prefix;

start returns [String value]
    :   p=program {$value = String.format("begin%s\nend.", $p.value);}
    ;

program returns [String value = ""]
    :   (act=action {$value += String.format("\n%s", $act.value);})*
    ;

action returns [String value = "\t"]
    :   a=assign {$value += $a.value;}
    |   p=print {$value += $p.value;}
    |   e=ifExpr {$value += $e.value;}
    ;

ifExpr returns [String value]
    :   'if' e=logicExpr act=action {$value = String.format("if (%s) then\n\t%s", $e.value, $act.value);}
    ;

assign returns [String value]
    :   '=' bVar=VarName le=logicExpr {$value = String.format("%s = %s;", $bVar.text, $le.value);}
    |   '=' var=VarName ae=arithmeticExpr {$value = String.format("%s = %s;", $var.text, $ae.value);}
    ;

print returns [String value]
    :   'print' le=logicExpr {$value = String.format("writeln(%s);", $le.value);}
    |   'print' ae=arithmeticExpr {$value = String.format("writeln(%s);", $ae.value);}
    ;

arithmeticExpr returns [String value]
    :   '+' e1=arithmeticExpr e2=arithmeticExpr {$value = String.format("(%s + %s)", $e1.value, $e2.value);}
    |   '-' e1=arithmeticExpr e2=arithmeticExpr {$value = String.format("(%s - %s)", $e1.value, $e2.value);}
    |   '*' e1=arithmeticExpr e2=arithmeticExpr {$value = String.format("%s * %s", $e1.value, $e2.value);}
    |   '/' e1=arithmeticExpr e2=arithmeticExpr {$value = String.format("(%s / %s)", $e1.value, $e2.value);}
    |   n=Number {$value = $n.text;}
    |   var=VarName {$value = $var.text;}
    ;

logicExpr returns [String value]
    :   'and' e1=logicExpr e2=logicExpr {$value = String.format("%s and %s", $e1.value, $e2.value);}
    |   'or' e1=logicExpr e2=logicExpr {$value = String.format("(%s or %s)", $e1.value, $e2.value);}
    |   'not' e=logicExpr {$value = String.format("not %s", $e.value);}
    |   b=Bool {$value = $b.text;}
    |   b=VarName {$value = $b.text;}
    |   '<' ae1=arithmeticExpr ae2=arithmeticExpr {$value = String.format("%s < %s", $ae1.value, $ae2.value);}
    |   '>' ae1=arithmeticExpr ae2=arithmeticExpr {$value = String.format("%s > %s", $ae1.value, $ae2.value);}
    |   '>=' ae1=arithmeticExpr ae2=arithmeticExpr {$value = String.format("%s >= %s", $ae1.value, $ae2.value);}
    |   '<=' ae1=arithmeticExpr ae2=arithmeticExpr {$value = String.format("%s <= %s", $ae1.value, $ae2.value);}
    |   '==' ae1=arithmeticExpr ae2=arithmeticExpr {$value = String.format("%s == %s", $ae1.value, $ae2.value);}
    |   '==' e1=logicExpr e2=logicExpr {$value = String.format("%s == %s", $e1.value, $e2.value);}
    |   '!=' ae1=arithmeticExpr ae2=arithmeticExpr {$value = String.format("%s != %s", $ae1.value, $ae2.value);}
    |   '!=' e1=logicExpr e2=logicExpr {$value = String.format("%s != %s", $e1.value, $e2.value);}
    ;

Number
    :    ('-')? ('0'..'9')+ ('.' ('0'..'9')+)?
    ;

Bool
    :   'true'
    |   'false'
    ;

VarName
    :   ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*
    ;

WS : [ \t\r\n]+ -> skip ;
