package Banque;

import java.time.LocalDateTime;
import java.util.Date;
enum SensOperation {
	Crédit,
	Débit
}
public class OperationsBancaire {

	private double sommeOpe;
	private LocalDateTime dateOpe;
	private SensOperation sens;  //avec une enum!
	private String descriptionOpe;
	
	public OperationsBancaire(double sommeOpe, SensOperation sensOpe, String descriptionOpe) {
		super();
		this.sommeOpe = sommeOpe;
		this.sens = sensOpe;
		this.descriptionOpe = descriptionOpe;
		this.dateOpe = LocalDateTime.now();
	}

	
	//Getters
	public double getSommeOpe() {
		return sommeOpe;
	}

	public LocalDateTime getDateOpe() {
		return dateOpe;
	}

	public SensOperation getSensOpe() {
		return sens;
	}

	public String getDescriptionOpe() {
		return descriptionOpe;
	}
	
	@Override
    public String toString() {
        return "\nType d'opération = " + sens +" | Somme = " + sommeOpe + ", le "+ dateOpe + ", " + descriptionOpe;
    }
	
	
	
}
