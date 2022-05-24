package com.practicas.springpool.models.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "lend", schema = "bookmypool", catalog = "")
public class LendEntity {
    private int id;
    private Date lendingDate;
    private Date returningDate;
    private int deviceId;
    private int employeeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lending_date", nullable = false)
    public Date getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(Date lendingDate) {
        this.lendingDate = lendingDate;
    }

    @Basic
    @Column(name = "returning_date", nullable = true)
    public Date getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(Date returningDate) {
        this.returningDate = returningDate;
    }

    @Basic
    @Column(name = "device_id", nullable = false)
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "employee_id", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LendEntity that = (LendEntity) o;

        if (id != that.id) return false;
        if (deviceId != that.deviceId) return false;
        if (employeeId != that.employeeId) return false;
        if (lendingDate != null ? !lendingDate.equals(that.lendingDate) : that.lendingDate != null) return false;
        if (returningDate != null ? !returningDate.equals(that.returningDate) : that.returningDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lendingDate != null ? lendingDate.hashCode() : 0);
        result = 31 * result + (returningDate != null ? returningDate.hashCode() : 0);
        result = 31 * result + deviceId;
        result = 31 * result + employeeId;
        return result;
    }
}
