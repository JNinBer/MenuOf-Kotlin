package cn.jninber.client.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

/**
 * Created by jninber on 2017/7/17.
 *
 **/
open class CategoryObject : RealmObject(), Serializable {
    @PrimaryKey
    var id: String = ""
    var type: Long? = null
    var name: String = ""
    var mark: String? = null
    var menu: RealmList<DetailObject>? = null
}