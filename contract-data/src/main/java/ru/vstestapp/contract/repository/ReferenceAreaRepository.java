package ru.vstestapp.contract.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vstestapp.contract.entity.ReferenceArea;

@Repository
public interface ReferenceAreaRepository extends CommonRepository<ReferenceArea> {
    @Query(value ="select ra.value from ReferenceArea ra where " +
            "(ra.rangeFrom is null and ra.rangeTo>=?1)or" +
            "(ra.rangeFrom<=?1 and ra.rangeTo>=?1)or" +
            "(ra.rangeFrom<=?1 and ra.rangeTo is null)")
    Float findByRangeCoefficient(Float rangeValue);
}
