package pl.fissst.lbd.springrestlbd.model;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int id;
    private String name;
    private String surname;
    private uniqueSubject subject;

}
