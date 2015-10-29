/**
 * Name: Carl Sim
 *
 * General Description:
 *  A simple application that converts a fahrenheit value that the user input to a celsius value
 *
 * Variable Description:
 *  - int fahrenheitInt holds the converted user input to an Integer value for the fahrenheitToCelsius() method
 *
 * Expected Results:
 * A window opens and prompts the user to enter a number for a number that resembles fahrenheit.
 * When the user presses the Return/Enter key or clicks on the "Calculate" button, it converts the user inputted number
 * and converts it to Celsius and displays it beside "Celsius Number: "
 *
 * Anticipated Bad Results:
 * Inputting a very large number won't work
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FahrenheitToCelsiusCalc extends JFrame {
    JTextField textFahrenheitField; /*Holds textField for Fahrenheit*/
    JLabel labelInstructions;       /*Holds Label for simple instructions of the app*/
    JLabel labelCelsius;            /*Holds Label for Celsius and final conversion*/
    JButton buttCalculate;          /*Button that holds "Calculate"*/

    int fahrenheitInt;

    public static void main(String[] args){
        new FahrenheitToCelsiusCalc();
    }

    public FahrenheitToCelsiusCalc(){
        /**
         * Set window size
         *
         * setSize(width, height)
         */
        this.setSize(400, 150);

        /**
         * Set the title of the window
         *
         * Title: Fahrenheit to Celsius Calculator
         */
        this.setTitle("Fahrenheit to Celsius Calculator");

        /**
         * Provide functionality to the top bar of the window to allow the "X" button to work (exit the window)
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Center window in relative to screen size when first opened
         */
        this.setLocationRelativeTo(null);

        /**
         * Main panel for the window
         * Uses GridBagLayout
         */
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridBagLayout());

        /**
         * Create new panel to hold all of the components for the "Input" area.
         * This includes labels, textFields and buttons
         *
         * JTextField textFahrenheitField;
         * JLabel labelInstructions;
         * JButton buttCalculate;
         */
        JPanel inputPanel = new JPanel();

        /**
         * Create a new layout for inputPanel to put inside the thePanel GridBagLayout.
         *
         * Syntax: new FlowLayout(FlowLayout.CENTER/LEFT/RIGHT (float to wherever), vertical padding, horizontal padding)
         * FlowLayout.CENTER - Float components inside bgPanel to the center
         * 10 - Vertical padding
         * 0 - Horizontal padding
         *
         */
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        /**
         * Label for "Instructions"
         * "Fahrenheit to Celsius"
         *
         * Create a new labelInstructions via JLabel()
         * Add it to inputPanel
         */
        labelInstructions = new JLabel("Fahrenheit to Celsius");
        inputPanel.add(labelInstructions);

        /**
         * textField for holding user input
         * Should contain valid numbers for fahrenheit
         *
         * Create a new textFahrenheitField via JTextField()
         * Add it to inputPanel
         */
        textFahrenheitField = new JTextField("", 5);
        inputPanel.add(textFahrenheitField);

        /**
         * button for holding user confirmation
         *
         * Create a new buttCalculate via JButton()
         * Title - "Calculate"
         *
         * Add it to inputPanel
         */
        buttCalculate = new JButton("Calculate");
        inputPanel.add(buttCalculate);

        /**
         * Create a new ActionListener for buttons pressed
         *
         * buttCalculate.addActionListener(buttonListener);
         *  - Listens for a click to display the needed calculation
         *
         * textFahrenheitField.addActionListener(buttonListener);
         *  - Listens if the user presses "Enter" to display the needed calculation
         */
        listenForButton buttonListener = new listenForButton();
        buttCalculate.addActionListener(buttonListener);
        textFahrenheitField.addActionListener(buttonListener);

        /**
         * Add component to main layout using the addComponent method
         * Will be aligned to the right(NORTH) and will fill the horizontal space(HORIZONTAL)
         */
        addComponent(thePanel, inputPanel, 0, 0, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);

        /**
         * Create new panel to hold all of the components for the "Calculation/Total" area.
         * This includes labels
         *
         * Added to totalPanel:
         * JLabel labelCelsius;
         */
        JPanel totalPanel = new JPanel();

        /**
         * Create a new layout for totalPanel to put inside the thePanel GridBagLayout.
         *
         * Syntax: new FlowLayout(FlowLayout.CENTER/LEFT/RIGHT (float to wherever), vertical padding, horizontal padding)
         * FlowLayout.CENTER - Float components inside bgPanel to the center
         * 10 - Vertical padding
         * 0 - Horizontal padding
         */
        totalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        /**
         * label for holding the final calculated value
         *
         * Create a new buttCalculate via JButton()
         * Default title - "Celsius Value: "
         * Edited title - "Celsius Value: --FAHRENHEIT TO CELSIUS CONVERSION--"
         *
         * Add it to totalPanel
         */
        labelCelsius = new JLabel("Celsius Value: ");
        totalPanel.add(labelCelsius);

        /**
         * Add component to main layout using the addComponent method
         * Will be aligned to the right(EAST) and will fill the horizontal space(HORIZONTAL)
         */
        addComponent(thePanel, totalPanel, 0, 0, 0, 0, GridBagConstraints.EAST, GridBagConstraints. HORIZONTAL);

        /**
         * Add the main panel to the window
         */
        this.add(thePanel);

        /**
         * Set visibility of the GUI to true
         */
        this.setVisible(true);
    }

    /**
     *
     * @param fahrenheitInt
     * int fahrenheit value
     * Should be what the user input in the textFahrenheitField
     *
     * @return
     * a conversion of fahrenheit to celsius.
     *
     * Formula "Celsius = (fahrenheitInt-32) * 5/9"
     */
    public static int fahrenheitToCelsius(int fahrenheitInt){
        return (fahrenheitInt-32) * 5/9;
    }

    private class listenForButton implements ActionListener{
       @Override
       public void actionPerformed(ActionEvent e) {
           /**
            * Checks to see if the "Calculate" button was pressed or if the Enter/Return key was pressed.
            */
           if(e.getSource() == buttCalculate || e.getSource() == textFahrenheitField){
               try{
                   /**
                    * Converts the text inside that holds the users input (Fahrenheit value) to an Integer for proper
                    * calculation via fahrenheitToCelsius() method.
                    */
                   fahrenheitInt = Integer.parseInt(textFahrenheitField.getText());
                   /**
                    * Catches any input that's not a number
                    */
               }catch(NumberFormatException exception){
                   /**
                    * An error message pops up for an invalid input (anything not a number)
                    */
                    JOptionPane.showMessageDialog(FahrenheitToCelsiusCalc.this, "Numbers only", "Error", JOptionPane.ERROR_MESSAGE);
               }
               /**
                * The labelCelsius text is changed to the converted Fahrenheit number.
                */
               labelCelsius.setText("Celsius Value: " + Integer.toString(fahrenheitToCelsius(fahrenheitInt)));
           }
       }
    }

    /**
     *
     * @param thePanel
     * Be able to add the passed component with the correct constraints to thePanel
     * thePanel = Main overall panel (minus the actual window (.this)
     *      *
     * @param component
     * The component itself (JPanel, JCheckBox, JTextBox, JPanel, etc)
     *
     * @param xPos
     * Default x position of component
     *
     * @param yPos
     * Default y position of component
     *
     * @param componentWidth
     * How many columns how many the component will span
     *
     * @param componentHeight
     * How many rows how many the component will span
     *
     * @param align
     * Where to place component if they dont fill space (NORTH, EAST, SOUTH, WEST, NORTHWEST, etc)
     *
     * @param stretch
     * How to stretch to fill remaining space (VERTICAL, HORIZONTAL, BOTH, NONE)
     */
    private void addComponent(JPanel thePanel,
                              JComponent component,
                              int xPos, //x position of component
                              int yPos, //y position of component
                              int componentWidth, //num of columns it covers
                              int componentHeight, //num of rows it covers
                              int align, //where to place component if they dont fill space (NORTH, EAST, SOUTH, WEST, NORTHWEST, etc)
                              int stretch){ //How to stretch to fill remaining space (VERTICAL, HORIZONTAL, BOTH, NONE)

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = xPos; //x position of component
        gridBagConstraints.gridy = yPos; //y position of component
        gridBagConstraints.gridwidth = componentWidth; //num of columns it covers
        gridBagConstraints.gridheight = componentHeight; //num of rows it covers
        gridBagConstraints.weightx = 100; //How components behave around one another
        gridBagConstraints.weighty = 100; //How components behave around one another
        gridBagConstraints.insets = new Insets(5, 5, 5, 5); //Padding around component
        gridBagConstraints.anchor = align; //where to place component if they don't fill space (NORTH, EAST, SOUTH, WEST, NORTHWEST, etc)
        gridBagConstraints.fill = stretch; //How to stretch to fill remaining space (VERTICAL, HORIZONTAL, BOTH, NONE)

        /**
         * Add the component passed in with the gridBagConstraints defined above
         */
        thePanel.add(component, gridBagConstraints);
    }
}
