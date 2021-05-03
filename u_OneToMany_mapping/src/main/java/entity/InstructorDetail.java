package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String youtube_channel;
	@Column
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail", cascade=CascadeType.ALL)
	//@OneToOne(cascade=CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	private Instructor instructor;
	

	public InstructorDetail() {
	}

	public InstructorDetail(String youtube_channel, String hobby) {
		this.youtube_channel = youtube_channel;
		this.hobby = hobby;
	}

	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtube_channel=" + youtube_channel + ", hobby=" + hobby
				+ ", instructor=" + instructor + "]";
	}

	


}
