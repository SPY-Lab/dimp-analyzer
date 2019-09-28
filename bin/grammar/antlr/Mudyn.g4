grammar Mudyn;

@header{
package grammar.antlr;
}



BOOL: 'true'
 | 'false';

ID: [a-zA-Z]+
 ;

INT: ('-')? [0-9]+
 ;

STRING: '"' ('\\"'|.)*? '"'
 ;


dimp: comm EOF           #ProgramExecution
 ;


exp:
   ID                              #IdName
 | '(' exp ')'                      #Parenthesis
    
 | INT                             #Int
 | 'len(' exp ')'                 #LenString
 | 'num(' exp ')'                 #CastStringToInt
 | exp '+' exp                   #Sum
 | exp '-' exp                   #Sot
 | exp '*' exp                   #Mol
 | 'new Number(' exp ')'          #ObjectNumber
 | exp '.indexOf(' exp ')'       #IndexOf

 | BOOL                            #Booleans
 | exp '&&' exp                  #LogicAnd
 | exp '||' exp                  #LogicOr
 | '!' exp                         #Negation
 | 'new Boolean(' exp ')'         #ObjectBoolean
 |  exp '==' exp                   #EqualExp
 |  exp '>' exp                    #GreaterExp
 |  exp '<' exp                    #LessExp
 
 | STRING                                  #StringGeneric
 | exp '.' exp                           #Concat
 | 'substring(' exp ',' exp ',' exp ')' #Substrings
 | 'new String(' exp ')'                  #ObjectString
 | exp '.charAt(' exp ')'                #CharAt
 ;

comm:
    'skip' ';'                                  #Skip
 |  ID '=' exp ';'                          #AssignmentStmt
 |  'if' '(' exp ')' block 'else' block     #IfStmt
 |  'while' '(' exp ')' block               #WhileStmt
 |  block                                   #BlockStmt
 |  comm comm                               #Composition
 |  'eval(' exp ')' ';'                     #Eval
 ;


block:  '{' '}'
 ?
 | '{' comm '}'
 ;

WS: [ \r\n\t] + -> skip
 ;