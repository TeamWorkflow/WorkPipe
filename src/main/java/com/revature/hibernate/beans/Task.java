package com.revature.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="task")
	@SequenceGenerator(name="task", sequenceName="task_seq", allocationSize=1)
	private Integer id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="status_id")
	private Integer statusId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Integer empId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="description_id")
	private String descriptionId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="project_id")
	private String projId;
	// need to add the description_id variable
	// then getters and setters for it, change the constructors,
	// the toString method, and the hash code and equals()
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getDescriptionId() {
		return descriptionId;
	}
	public void setDescriptionId(String descriptionId) {
		this.descriptionId = descriptionId;
	}
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descriptionId == null) ? 0 : descriptionId.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((projId == null) ? 0 : projId.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (descriptionId == null) {
			if (other.descriptionId != null)
				return false;
		} else if (!descriptionId.equals(other.descriptionId))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (projId == null) {
			if (other.projId != null)
				return false;
		} else if (!projId.equals(other.projId))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "task [id=" + id + ", statusId=" + statusId + ", empId=" + empId + ", descriptionId=" + descriptionId
				+ ", projId=" + projId + "]";
	}
	public Task() {
		super();
	}
	public Task(Integer id, Integer statusId, Integer empId, String descriptionId, String projId) {
		super();
		this.id = id;
		this.statusId = statusId;
		this.empId = empId;
		this.descriptionId = descriptionId;
		this.projId = projId;
	}
	
}
