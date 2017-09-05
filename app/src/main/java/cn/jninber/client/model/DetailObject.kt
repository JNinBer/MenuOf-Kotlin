package cn.jninber.client.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

/**
 * Created by jninber on 2017/7/17.
 *
 **/
open class DetailObject : RealmObject(),Serializable {
    @PrimaryKey
    var id: String = ""

    var name: String? = null;

    var img: String? = null

    var introduction: String? = null

    var material: RealmList<MaterialObject>? = null

    var procedure: String? = null

    var mark: String? = null

    var favorite: Boolean = false
}