package jessefu.me.component_base.orm.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import jessefu.me.component_base.orm.entity.RecordEntity;

/**
 * @author Jesse Fu
 * @date 2020/11/27
 * @description
 */
public interface RecordDao {

    @Query("SELECT * FROM record_entity")
    List<RecordEntity> getAll();

    @Query("SELECT * FROM RECORD_ENTITY WHERE tag LIKE :tag")
    List<RecordEntity> findByTag(String tag);

    @Query("SELECT * FROM RECORD_ENTITY WHERE category LIKE :category")
    List<RecordEntity> findByCategory(String category);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RecordEntity recordEntity);

    @Delete
    int delete(RecordEntity recordEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int update(RecordEntity recordEntity);


}
