package model.command;

public class Controle {

    private Command slot_botaoR[] = new Command[5];
    private Command slot_botaoL[] = new Command[5];

    // set slot de commandos

    public void setSlot_botaoL(Command command, int n) {
        this.slot_botaoL[n] = command;
    }

    public void setSlot_botaoR(Command command, int n) {
        this.slot_botaoR[n] = command;
    }

    //execute quando o botão for apertado
    public void pressBotaoL(int n) {
        slot_botaoL[n].execute();
    }
    public void pressBotaoR(int n) {slot_botaoL[n].execute();}

    public void ExecuteCommands(int op) {
        if (op == 0) {
            pressBotaoL(0);
        } else if (op == 1) {
            pressBotaoL(1);
        } else if (op == 2) {
            pressBotaoL(2);
        } else if (op == 3) {
            pressBotaoL(3);
        } else if (op == 4) {
            pressBotaoR(0);
        } else if (op == 5) {
            pressBotaoR(1);
        } else if (op == 6) {
            pressBotaoR(2);
        } else if (op == 7) {
            pressBotaoR(3);
        }
    }

}
