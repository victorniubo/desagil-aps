package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Switch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class GateView extends JPanel implements ActionListener, MouseListener{
    private final Gate gate;

    private final Switch switch0;
    private final Switch switch1;

    private final JCheckBox in0;
    private final JCheckBox in1;
    private final JCheckBox out;

    public GateView (Gate gate){
        this.gate = gate;

        switch0 = new Switch();
        switch1 = new Switch();

        in0 = new JCheckBox();
        in1 = new JCheckBox();
        out = new JCheckBox();

        JLabel in0Label = new JLabel("Entrada 1");
        JLabel in1Label = new JLabel("Entrada 2");
        JLabel outLabel = new JLabel("Saida");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(in0Label);
        add(in0);
        if (gate.getInputSize() > 1){
            add(in1Label);
            add(in1);
            in1.addActionListener(this);
        }
        add(outLabel);
        add(out);

        in0.addActionListener(this);
        out.setEnabled(false);

        update();

    }

    private void update() {
        boolean saida;

        if (in0.isSelected()){
            switch0.turnOn();
        }
        else{
            switch0.turnOff();
        }

        if (in1.isSelected()){
            switch1.turnOn();
        }
        else {
            switch1.turnOff();
        }

        saida = gate.read();

        gate.connect(0,switch0);
        if (gate.getInputSize() > 1){
            gate.connect(1, switch1);
        }

        if (saida == true){
            out.setSelected(true);
        }
        else{
            out.setSelected(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
