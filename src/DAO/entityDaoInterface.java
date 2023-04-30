package DAO;

import java.math.BigDecimal;
import java.util.List;

public interface entityDaoInterface<T> {
        public List<T> getRows();
        public boolean addRow(T t);
        public boolean deleteRow(BigDecimal id);

}
