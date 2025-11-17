import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ReservaCodeSys extends JFrame implements ActionListener{
    JLabel titulo, logo;
    JLabel noml, apel, dnil, tefl, fechl, origl, destl, tipol, accl, pisosl, calidadl;
    JTextField nomt, apelt, dnit, teft, fecht;
    JCheckBox audifonoc, mantac, revistac;
    JRadioButton piso1, piso2;
    ButtonGroup grupopisos;
    JComboBox<String> origenCB, destinoCB;
    JList<String> calidadLista;
    JScrollPane scrollLista;
    JButton confirmb, resetb;
    String piso;

    public ReservaCodeSys(){
        super("CodeSys");
        setSize(900, 700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel encabezado=new JPanel(new BorderLayout());
        titulo=new JLabel("CodeSys", SwingConstants.LEFT);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        logo=new JLabel(new ImageIcon("codesyslogo.png"), SwingConstants.RIGHT);
        encabezado.add(titulo, BorderLayout.WEST);
        encabezado.add(logo, BorderLayout.EAST);	
        add(encabezado, BorderLayout.NORTH);
        JPanel formulario=new JPanel(new GridLayout(9, 2, 10, 10));
        formulario.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        noml=new JLabel("Nombre:");
        apel=new JLabel("Apellido:");
        dnil=new JLabel("DNI:");
        tefl=new JLabel("Telefono:");
        fechl=new JLabel("Fecha de Viaje:");
        origl=new JLabel("Origen:");
        destl=new JLabel("Destino:");
        accl=new JLabel("Accesorios:");
        pisosl=new JLabel("Piso:");
        calidadl=new JLabel("Calidad:");

        nomt=new JTextField();
        apelt=new JTextField();
        dnit=new JTextField();
        teft=new JTextField();
        fecht=new JTextField();

        origenCB=new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Narnia", "Roma"});
        destinoCB=new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Narnia", "Roma"});

        audifonoc=new JCheckBox("Audifonos");
        mantac=new JCheckBox("Manta");
        revistac=new JCheckBox("Revistas");

        JPanel panelChecks=new JPanel(new FlowLayout());
        panelChecks.add(audifonoc);
        panelChecks.add(mantac);
        panelChecks.add(revistac);

        piso1=new JRadioButton("1er Piso");
        piso2=new JRadioButton("2do Piso");
        grupopisos=new ButtonGroup();
        grupopisos.add(piso1);
        grupopisos.add(piso2);

        JPanel panelRadio=new JPanel(new FlowLayout());
        panelRadio.add(piso1);
        panelRadio.add(piso2);

        String[] opciones={"Económico", "Standard", "VIP"};
        calidadLista=new JList<>(opciones);
        calidadLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollLista=new JScrollPane(calidadLista);

        formulario.add(noml);  
        formulario.add(nomt);
        formulario.add(apel);
        formulario.add(apelt);
        formulario.add(dnil);
        formulario.add(dnit);
        formulario.add(tefl);
        formulario.add(teft);
        formulario.add(fechl);
        formulario.add(fecht);
        formulario.add(origl);
        formulario.add(origenCB);
        formulario.add(destl);
        formulario.add(destinoCB);
        formulario.add(accl);
        formulario.add(panelChecks);
        formulario.add(pisosl);
        formulario.add(panelRadio);
        formulario.add(calidadl);
        formulario.add(scrollLista);
        add(formulario, BorderLayout.CENTER);
        
        JPanel botonesPanel=new JPanel(new FlowLayout());
        confirmb=new JButton("Confirmar");
        resetb=new JButton("Reiniciar");
        confirmb.addActionListener(this);
        resetb.addActionListener(this);
        botonesPanel.add(confirmb);
        botonesPanel.add(resetb);
        add(botonesPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==confirmb){
            mostrarResumen();
        }
        if(e.getSource()==resetb){
            resetearFormulario();
        }
    }

    private void resetearFormulario(){
        nomt.setText("");
        apelt.setText("");
        dnit.setText("");
        teft.setText("");
        fecht.setText("");
        origenCB.setSelectedIndex(0);
        destinoCB.setSelectedIndex(0);
        audifonoc.setSelected(false);
        mantac.setSelected(false);
        revistac.setSelected(false);
        grupopisos.clearSelection();
        calidadLista.clearSelection();
    }

    private void mostrarResumen() {
        String nombre=nomt.getText();
        String apellido=apelt.getText();
        String dni=dnit.getText();
        String tel=teft.getText();
        String fecha=fecht.getText();
        String origen=(String) origenCB.getSelectedItem();
        String destino=(String) destinoCB.getSelectedItem();
        String servicios="";
        if(audifonoc.isSelected()){
            servicios +="Audífonos ";
        }
        if(mantac.isSelected()){
            servicios +="Manta ";
        }
        if (revistac.isSelected()){
            servicios += "Revistas ";
        }
        if (servicios.equals("")){
            servicios=" ";
        }
        if(piso1.isSelected()){
            piso="1er Piso";
        }else if(piso2.isSelected()){
            piso="2do Piso";
        }else{
            piso=" ";
        }
        String calidad=calidadLista.getSelectedValue();
        if(calidad==null){
            calidad=" ";
        }
        String mensaje="Chekout\nNombre: "+nombre +"\nApellido: "+apellido+"\nDNI: "+dni+"\nTelefono: "+tel+"\nFecha de Viaje: "+fecha+"\nOrigen: "+origen+"\nDestino: "+destino+"\nAccesorios: "+servicios+"\nPiso: "+piso+"\nCalidad: "+calidad+"\n";
        JOptionPane.showMessageDialog(this, mensaje, "Resumen", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args){
        new ReservaCodeSys();
    }
}
