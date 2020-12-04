package jessefu.me.component_base.router;

/**
 * author: Jesse Fu
 * date: 2020/11/28 17:43
 * description:
 */
public class RouterConstants {

    private RouterConstants(){}

    /**module_pass*/
    public static final String MODULE_PASS = "/module_pass";

    //主页
    public static final String ACTIVITY_MAIN_PAGE = "activity_main_page";

    //编辑页
    public static final String ACTIVITY_EDIT = "activity_edit";
    //编辑页需要参数: id
    public static final String KEY_EDIT_ID = "key_edit_id";

    //详情页
    public static final String ACTIVITY_DETAIL = "activity_detail";
    //详情页需要参数: id
    public static final String KEY_DETAIL_ID = "key_detail_id";

    /*************************module_pass end*****************************/




    /**module_setting*/
    public static final String MODULE_SETTING = "/module_setting/";

    public static final String ACTIVITY_SETTING = "activity_setting";
    /****************************module_setting end****************************/
}
