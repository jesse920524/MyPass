package jessefu.me.component_base.orm.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Jesse Fu
 * @date 2020/11/27
 * @description
 */
@Entity(tableName = "record_entity")
public class RecordEntity {

    @PrimaryKey(autoGenerate = true)
    public long uid;

    @ColumnInfo(name = "account")
    public String account;

    @ColumnInfo(name = "encrypted_pwd")
    public String encryptedPwd;

    @ColumnInfo(name = "tag")
    public String tag;

    @ColumnInfo(name = "star")
    public boolean star;

    @ColumnInfo(name = "category")
    public String category;

    @ColumnInfo(name = "desc")
    public String desc;

    @Override
    public String toString() {
        return "RecordEntity{" +
                "uid=" + uid +
                ", account='" + account + '\'' +
                ", encryptedPwd='" + encryptedPwd + '\'' +
                ", tag='" + tag + '\'' +
                ", star=" + star +
                ", category='" + category + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
