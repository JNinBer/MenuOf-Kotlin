package cn.jninber.client.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

/**
 * Created by jninber on 2017/7/17.
 *
 **/
open class MaterialObject : RealmObject(),Serializable {
    @PrimaryKey
    var id: String = ""
    var name: String? = null
    var weight: Double? = 0.0

}