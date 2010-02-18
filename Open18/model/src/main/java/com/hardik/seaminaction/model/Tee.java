package com.hardik.seaminaction.model;
// Generated Sep 7, 2009 10:56:32 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * Tee generated by hbm2java
 */
@Entity
@Table(name = "tee", schema = "public")
public class Tee implements java.io.Serializable {

	private TeeId id;
	private TeeSet teeSet;
	private Hole hole;
	private int distance;

	public Tee() {
	}

	public Tee(TeeId id, TeeSet teeSet, Hole hole, int distance) {
		this.id = id;
		this.teeSet = teeSet;
		this.hole = hole;
		this.distance = distance;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "teeSetId", column = @Column(name = "tee_set_id", nullable = false)),
			@AttributeOverride(name = "holeId", column = @Column(name = "hole_id", nullable = false))})
	@NotNull
	public TeeId getId() {
		return this.id;
	}

	public void setId(TeeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tee_set_id", nullable = false, insertable = false, updatable = false)
	@NotNull
	public TeeSet getTeeSet() {
		return this.teeSet;
	}

	public void setTeeSet(TeeSet teeSet) {
		this.teeSet = teeSet;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hole_id", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Hole getHole() {
		return this.hole;
	}

	public void setHole(Hole hole) {
		this.hole = hole;
	}

	@Column(name = "distance", nullable = false)
	public int getDistance() {
		return this.distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}