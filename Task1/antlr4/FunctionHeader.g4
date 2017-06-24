grammar FunctionHeader;

header              : KEYWORD NAME '(' argList ')' ':' NAME ';' ;

argList             : nonEmptyArgList* ;

nonEmptyArgList     : NAME ':' NAME
                    | nonEmptyArgList ',' nonEmptyArgList ;

KEYWORD             : ('function' | 'procedure') ;

NAME                : ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;

WS : [ \t\r\n]+ -> skip ;