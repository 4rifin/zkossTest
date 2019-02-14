package zkoss;

import java.util.logging.Logger;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;



public class RegistrationComposer extends SelectorComposer<Component> {

	private static final long serialVersionUID = 4791844410411525116L;

	private static Logger logger = Logger.getLogger(RegistrationComposer.class.getName());
	
	@Wire("#nameBox")
	private Textbox nameBox;
	@Wire("#genderRadio")
	private Radiogroup genderRadio;
	@Wire("#birthdayBox")
	private Datebox birthdayBox;
	
	@Wire
	private Button submitButton;
	@Wire("#acceptTermBox")
	private Checkbox acceptTermCheckbox;
	
	@Listen("onCheck = #acceptTermBox")
	public void changeSubmitStatus(){
		if(acceptTermCheckbox.isChecked()) {
			submitButton.setDisabled(false);
			submitButton.setImage("images/add.png");
		}
		if(!acceptTermCheckbox.isChecked()) {
			submitButton.setDisabled(true);
			submitButton.setImage("");
		}
	}
	
	@Listen("onClick = #resetButton")
	public void resetAction() {
		clean();
	}
	
	public void clean() {
		nameBox.setRawValue("");
		birthdayBox.setRawValue(null);
		nameBox.setFocus(true);
	}
	
	@Listen("onClick = #submitButton")
	public void submitForm() {
		Messagebox.show("Congratulation! "+nameBox.getValue()+" "+genderRadio.getTooltip()+". Your registration is success.");
		logger.info("Congratulation! "+nameBox.getValue()+" "+genderRadio.getTooltip()+". Your registration is success.");
		clean();
	}
}
