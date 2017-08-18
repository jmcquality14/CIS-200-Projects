using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab11_Calculator {

    public partial class Form1 : Form {
        double result = 0;
        string operationPerformed = "";
        bool OperationPerformed = false;

        // private Button[] buttons;

        public Form1() {
            InitializeComponent();
        } // end of Form1

        private void button_Click(object sender, EventArgs e) {

            if ( OperationPerformed ) {
                answerText.Clear();
            }

            if ( buttonEquals.Enabled == false) {
                Display.Text = "";
                answerText.Clear();
                result = 0;
                buttonEquals.Enabled = true;
            }

            OperationPerformed = false;
            Button button = (Button)sender;
            answerText.Text = answerText.Text + button.Text;

        } // end of button_Click

        /*
        private void button0_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "0";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "1";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "2";
        }

        private void button3_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "3";
        }

        private void button4_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "4";
        }

        private void button5_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "5";
        }

        private void button6_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "6";
        }

        private void button7_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "7";
        }

        private void button8_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "8";
        }

        private void button9_Click(object sender, EventArgs e)
        {
            answerText.Text = answerText.Text + "9";
        }
        */

        private void operator_Click(object sender, EventArgs e) {
            Button button = (Button)sender;

            if (result != 0) {
                if ( buttonEquals.Enabled == false ) {
                    Display.Text = "";
                    buttonEquals.Enabled = true;
                    operationPerformed = button.Text;
                    Display.Text = Display.Text + " " + answerText.Text + " " + operationPerformed;
                    OperationPerformed = true;
                } else {
                    string tempOperationPerformed = button.Text;
                    Display.Text = Display.Text + " " + answerText.Text + " " + tempOperationPerformed;
                    switch (operationPerformed) {
                        case "+":
                            answerText.Text = (result + Double.Parse(answerText.Text)).ToString();
                            break;
                        case "-":
                            answerText.Text = (result - Double.Parse(answerText.Text)).ToString();
                            break;
                        case "/":
                            answerText.Text = (result / Double.Parse(answerText.Text)).ToString();
                            break;
                        case "*":
                            answerText.Text = (result * Double.Parse(answerText.Text)).ToString();
                            break;
                        default:
                            break;
                    } // end of switch
                    result = Double.Parse(answerText.Text);
                    operationPerformed = button.Text;
                    OperationPerformed = true;
                }
            } else {
                Display.Text = "";  // Clears Display
                operationPerformed = button.Text;
                result = Double.Parse(answerText.Text);
                Display.Text = result + " " + operationPerformed;
                OperationPerformed = true;
            }


           
        } // end of operator_Click

        private void buttonClear_Click(object sender, EventArgs e)
        {
            answerText.Text = "";
            Display.Text = "";
            operationPerformed = "";
            result = 0;
            buttonEquals.Enabled = true;
        } // end of buttonClear_Click

        /*
        private void buttonPlus_Click(object sender, EventArgs e)
        {
            answerText.Text = " + " + answerText.Text;
        }

        private void buttonMinus_Click(object sender, EventArgs e)
        {
            answerText.Text = " - " + answerText.Text; ;
        }

        private void buttonDivision_Click(object sender, EventArgs e)
        {
            answerText.Text = " / " + answerText.Text; ;
        }

        private void buttonMultiply_Click(object sender, EventArgs e)
        {
            answerText.Text = " * " + answerText.Text; ;
        }
        */

        private void buttonEquals_Click(object sender, EventArgs e) {
            Display.Text = Display.Text + " " + answerText.Text;
            switch ( operationPerformed ) {
                case "+":
                    answerText.Text = ( result + Double.Parse(answerText.Text) ).ToString() ;
                    break;
                case "-":
                    answerText.Text = ( result - Double.Parse(answerText.Text) ).ToString();
                    break;
                case "/":
                    answerText.Text = ( result / Double.Parse(answerText.Text) ).ToString();
                    break;
                case "*":
                    answerText.Text = ( result * Double.Parse(answerText.Text) ).ToString();
                    break;
                default:
                    break;
            } // end of switch

            buttonEquals.Enabled = false;
            result = Double.Parse( answerText.Text );

        } // end of buttonEquals_Click

        private void answerText_TextChanged(object sender, EventArgs e) {
            if( answerText.TextLength >= 19 ) {
                button0.Enabled = false;
                button1.Enabled = false;
                button2.Enabled = false;
                button3.Enabled = false;
                button4.Enabled = false;
                button5.Enabled = false;
                button6.Enabled = false;
                button7.Enabled = false;
                button8.Enabled = false;
                button9.Enabled = false;
                buttonPlus.Enabled = false;
                buttonMinus.Enabled = false;
                buttonDivision.Enabled = false;
                buttonMultiply.Enabled = false;
                buttonEquals.Enabled = false;
                answerText.Text = "Number too Large   ";
            } else {
                button0.Enabled = true;
                button1.Enabled = true;
                button2.Enabled = true;
                button3.Enabled = true;
                button4.Enabled = true;
                button5.Enabled = true;
                button6.Enabled = true;
                button7.Enabled = true;
                button8.Enabled = true;
                button9.Enabled = true;
                buttonPlus.Enabled = true;
                buttonMinus.Enabled = true;
                buttonDivision.Enabled = true;
                buttonMultiply.Enabled = true;
                buttonEquals.Enabled = true;
            }
        } // end of answerText_TextChanged


        private void Form1_Load(object sender, EventArgs e)
        {

        }


    } // end of Form1
} // end of Calculator
