/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpr.posfixa;

import br.edu.ifpr.posfixa.stack.PostFixEvaluator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Aluno
 */
public class FXMLPrincipalController implements Initializable {
    
    @FXML
    private Label lbOperacao;
    @FXML
    private TextField txfOperacao;
    @FXML
    private TextField txfResultado;
    @FXML
    private ToggleButton tbtnAdventure;
    @FXML
    private Button btnCalcula;
    
    @FXML
    private RadioButton rbtnHabilitar;     
    @FXML
    private RadioButton rbtnDesabilitar;
    
//    @FXML
//    private CheckBox cbxDados;
    
    
    PostFixEvaluator avaliador = new PostFixEvaluator();

    @FXML
    private void pressionaBotaoCalcula(ActionEvent e){
        //op recebe o que estava colocado no campo operacao
        String op = txfOperacao.getText();
        //expressao da outra classe atribuida a partir da string op;
        avaliador.setExpression(op);
        //o texto do campo resultado será definido a partir do calculo do metodo avalia;
        txfResultado.setText(avaliador.avalia().toString());
        //limpa o campo
        txfOperacao.clear();
    }
    
    @FXML
    private void radioButtonSelect(ActionEvent e){
        
        /* maneira que o professor passou, que só da certo se mecher lá no arquivo fxml */
        if(rbtnHabilitar.isSelected()){
           lbOperacao.setDisable(false);
           txfOperacao.setDisable(false);
        }
        else if(rbtnDesabilitar.isSelected()){
            txfOperacao.setDisable(true);
            txfOperacao.clear();
        }
        
        
        /* MANEIRA QUE HAVIA CONSEGUIDO FAZER, USANDO ARMED */
//        if(rbtnHabilitar.isArmed()){
//           rbtnDesabilitar.setSelected(false);
//           lbOperacao.setDisable(false);
//           txfOperacao.setDisable(false);
//        }
//        else if(rbtnDesabilitar.isArmed()){
//            rbtnHabilitar.setSelected(false);
//            txfOperacao.setDisable(true);
//            txfOperacao.clear();
//        }
    }
    
//    @FXML
//    private void checkBoxSelect(ActionEvent e){
//        //comparacao para habilitar o campo operacao somente quando o checkbox estiver habilitado;
//        if(cbxDados.isSelected()==false){
//            txfOperacao.setDisable(true);
//            txfOperacao.clear();
//        }
//        else{
//            lbOperacao.setDisable(false);
//            txfOperacao.setDisable(false);
//            
//        }
//    }
    
    @FXML
    public void expressaoOnKeyReleased(KeyEvent e){
        //atribuo string na expressao a ser tokenizada na outra classe;
        String op = txfOperacao.getText();
        
        //desabilita o botao se o text field da operaçao estiver vazio OU contenha somente um espaço;
        btnCalcula.setDisable((op.isEmpty()) || (op.equals(" ")) );
        //desabilita o text field resultado se o text field operaçao estiver vazio;
        txfResultado.setDisable(op.isEmpty());
        
        
        
//        //habilita o check box se ha texto no campo;
//        cbxDados.setSelected((op.isEmpty()==false));
//        //habilita o estado indeterminado no checkbox se o text field operacao conter somente um espaço;
//        cbxDados.setIndeterminate(op.trim().length()==0);
        
        
        //se pressionar enter simulará o clique no botao;
        if (e.getCode()==KeyCode.ENTER){
            btnCalcula.fire();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txfOperacao.requestFocus();
        txfOperacao.setDisable(true);
    }    
    
}
