package br.pro.hashi.ensino.desagil.aps.model.view;
import br.pro.hashi.ensino.desagil.aps.model.Gate;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class GateView extends JPanel implements ActionListener {

    private final Gate gate;
    private final JCheckBox pino1;
    private final JCheckBox pino2;
    private final JCheckBox saida;

    public GateView(Gate gate){
        this.gate = gate;
        pino1 = new JCheckBox();
        pino2 = new JCheckBox();
        saida = new JCheckBox();

        JLabel pino1label = new JLabel("Entrada");
        JLabel pino2label = new JLabel("Entrada");
        JLabel saidalabel = new JLabel("Saida");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(pino1label);
        add(pino1);
        add(pino2label);
        add(pino2);
        add(saidalabel);
        add(saida);

        pino1.addActionListener(this);
        pino2.addActionListener(this);
        saida.setEnabled(false);
    }


}
