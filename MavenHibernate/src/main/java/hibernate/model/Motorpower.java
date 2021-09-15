package hibernate.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Motorpower")

public class Motorpower  {

private int motorPower;
	
	public int getCarColor() {
        return motorPower;
    }
 
    public void setMotorPower(int motorPower) {
        this.motorPower = motorPower;
    }    
}
