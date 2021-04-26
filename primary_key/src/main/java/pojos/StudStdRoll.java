package pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudStdRoll implements Serializable {
	@Column
	private int std;
	@Column
	private int roll;
	public StudStdRoll() {
	}
	public StudStdRoll(int std, int roll) {
		super();
		this.std = std;
		this.roll = roll;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "StudStdRoll [std=" + std + ", roll=" + roll + "]";
	}
}
