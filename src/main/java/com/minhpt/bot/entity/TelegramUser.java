package com.minhpt.bot.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class TelegramUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private Long userId;

    @Column
    private String vCard;

    @Column
    private long point;

    @Column
    private long correctAnswer;

    @Column
    private long wrongAnswer;

    @Column
    private long totalAnswer = correctAnswer + wrongAnswer;

    @Column
    private double percentCorrectAnswer = totalAnswer > 0 ? (correctAnswer%totalAnswer)*100 : 0 ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getvCard() {
        return vCard;
    }

    public void setvCard(String vCard) {
        this.vCard = vCard;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public long getCorrectAnswer() {
        return correctAnswer;
    }

    public void plusCorrectAnswer() {
        this.correctAnswer++;
    }

    public long getWrongAnswer() {
        return wrongAnswer;
    }

    public void plusWrongAnswer() {
        this.wrongAnswer++;
    }

    public long getTotalAnswer() {
        return totalAnswer;
    }

    public double getPercentCorrectAnswer() {
        return percentCorrectAnswer;
    }
}
