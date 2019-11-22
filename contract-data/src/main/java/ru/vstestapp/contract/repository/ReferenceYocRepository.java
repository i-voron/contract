package ru.vstestapp.contract.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vstestapp.contract.entity.ReferenceYearOfConstruction;

@Repository
public interface ReferenceYocRepository extends CommonRepository<ReferenceYearOfConstruction> {
    @Query(value ="select ryoc.value from ReferenceYearOfConstruction ryoc where " +
            "(ryoc.rangeFrom is null and ryoc.rangeTo>=?1)or" +
            "(ryoc.rangeFrom<=?1 and ryoc.rangeTo>=?1)or" +
            "(ryoc.rangeFrom<=?1 and ryoc.rangeTo is null)")
    Float findByRangeCoefficient(Float rangeValue);
}
