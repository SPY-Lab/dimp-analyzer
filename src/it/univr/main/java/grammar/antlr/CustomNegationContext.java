package grammar.antlr;

public class CustomNegationContext extends MudynParser.ExpContext{

    MudynParser.ExpContext child;

    public CustomNegationContext(MudynParser.ExpContext child){
        this.child = child;
    }

    @Override
    public String getText() {
        return "!(" + child.getText() + ")";
    }

    public MudynParser.ExpContext getChild() {
        return child;
    }

    public void setChild(MudynParser.ExpContext child) {
        this.child = child;
    }

    //TODO metodi che aggiungono l'informazione semantica di NOT
}
