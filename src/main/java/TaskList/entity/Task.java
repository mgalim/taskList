package TaskList.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String description;

    @Column(name = "state",columnDefinition = "varchar(100) default 'PENDING'")
    @Enumerated(EnumType.STRING)
    private StateType stateType;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "employee_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee employee;
}
