package ru.vstestapp.contract.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vstestapp.contract.entity.Insurant;

import java.util.List;

@Repository
public interface InsurantRepository extends CommonRepository<Insurant> {
//    List<Insurant> findBySurnameIgnoreCaseAndNameIgnoreCaseAndPatronymicIgnoreCaseOrderBySurname(
//            String surname,String name,String patronymic);
    @Query(value = "select distinct * FROM Insurant i WHERE upper(concat(i.surname,i.name,i.patronymic)) " +
            "like upper(concat(?1,'%',?2,'%',?3,'%'))",nativeQuery = true)
    List<Insurant> findFio(String surname,String name,String patronymic);
}
