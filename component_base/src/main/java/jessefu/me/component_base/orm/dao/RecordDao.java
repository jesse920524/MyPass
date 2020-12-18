package jessefu.me.component_base.orm.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
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
@Dao
public interface RecordDao {

    /**读取全部*/
    @Query("SELECT * FROM RECORD_ENTITY")
    LiveData<List<RecordEntity>> getAll();

    /**根据tag读取*/
    @Query("SELECT * FROM RECORD_ENTITY WHERE tag LIKE :tag")
    LiveData<List<RecordEntity>> findByTag(String tag);

    /**根据category读取*/
    @Query("SELECT * FROM RECORD_ENTITY WHERE category LIKE :category")
    LiveData<List<RecordEntity>> findByCategory(String category);

    /**根据id读取*/
    @Query("SELECT * FROM RECORD_ENTITY WHERE uid == :id")
    LiveData<RecordEntity> findById(long id);

    /**@return id*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(RecordEntity recordEntity);

    /**@return affected rows*/
    @Delete
    int delete(RecordEntity recordEntity);

    /**@return affected rows*/
    @Update(onConflict = OnConflictStrategy.REPLACE)
    int update(RecordEntity recordEntity);


}
