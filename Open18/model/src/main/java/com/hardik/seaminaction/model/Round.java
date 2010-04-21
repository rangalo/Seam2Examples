package com.hardik.seaminaction.model;



import org.hibernate.validator.NotNull;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Apr 19, 2010
 * Time: 5:20:34 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "round")
public class Round {
    private Long id;
    private Integer version;
    private Date date;
    private String notes;
    private Golfer golfer;
    private TeeSet teeSet;
    private Integer totalScore;
    private Weather weather;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Lob
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GOLFER_ID", nullable = false)
    @NotNull
    public Golfer getGolfer() {
        return golfer;
    }

    public void setGolfer(Golfer golfer) {
        this.golfer = golfer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEE_SET_ID", nullable = false)
    @NotNull
    public TeeSet getTeeSet() {
        return teeSet;
    }

    public void setTeeSet(TeeSet teeSet) {
        this.teeSet = teeSet;
    }

    @Column(name = "total_score")
    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    @Enumerated(EnumType.STRING)
    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
