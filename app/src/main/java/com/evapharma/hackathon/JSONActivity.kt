package com.evapharma.hackathon

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.evapharma.hackathon.retrofit.Posts
import com.evapharma.hackathon.retrofit.PostsItem
import org.json.JSONArray

class JSONActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jsonactivity)
        convertJSONResultToObject(result)
    }
}

fun convertJSONResultToObject(result: String): Posts {
    val postList = ArrayList<PostsItem>()
    val responseJSON = JSONArray(result)
    for (i in 0 until responseJSON.length()) {
        val postJSON = responseJSON.getJSONObject(i)
        val userID = postJSON.getInt("userId")
        val id = postJSON.getInt("id")
        val title = postJSON.getString("title")
        val body = postJSON.getString("body")
        val postsItem = PostsItem(userId = userID, id = id, body = body, title = title)
        Log.d("Posts",postsItem.toString())
        postList.add(postsItem)
    }
    return Posts(postList)


}

val result = "[\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 1,\n" +
        "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
        "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 2,\n" +
        "    \"title\": \"qui est esse\",\n" +
        "    \"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 3,\n" +
        "    \"title\": \"ea molestias quasi exercitationem repellat qui ipsa sit aut\",\n" +
        "    \"body\": \"et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 4,\n" +
        "    \"title\": \"eum et est occaecati\",\n" +
        "    \"body\": \"ullam et saepe reiciendis voluptatem adipisci\\nsit amet autem assumenda provident rerum culpa\\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\\nquis sunt voluptatem rerum illo velit\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 5,\n" +
        "    \"title\": \"nesciunt quas odio\",\n" +
        "    \"body\": \"repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 6,\n" +
        "    \"title\": \"dolorem eum magni eos aperiam quia\",\n" +
        "    \"body\": \"ut aspernatur corporis harum nihil quis provident sequi\\nmollitia nobis aliquid molestiae\\nperspiciatis et ea nemo ab reprehenderit accusantium quas\\nvoluptate dolores velit et doloremque molestiae\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 7,\n" +
        "    \"title\": \"magnam facilis autem\",\n" +
        "    \"body\": \"dolore placeat quibusdam ea quo vitae\\nmagni quis enim qui quis quo nemo aut saepe\\nquidem repellat excepturi ut quia\\nsunt ut sequi eos ea sed quas\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 8,\n" +
        "    \"title\": \"dolorem dolore est ipsam\",\n" +
        "    \"body\": \"dignissimos aperiam dolorem qui eum\\nfacilis quibusdam animi sint suscipit qui sint possimus cum\\nquaerat magni maiores excepturi\\nipsam ut commodi dolor voluptatum modi aut vitae\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 9,\n" +
        "    \"title\": \"nesciunt iure omnis dolorem tempora et accusantium\",\n" +
        "    \"body\": \"consectetur animi nesciunt iure dolore\\nenim quia ad\\nveniam autem ut quam aut nobis\\net est aut quod aut provident voluptas autem voluptas\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 10,\n" +
        "    \"title\": \"optio molestias id quia eum\",\n" +
        "    \"body\": \"quo et expedita modi cum officia vel magni\\ndoloribus qui repudiandae\\nvero nisi sit\\nquos veniam quod sed accusamus veritatis error\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 2,\n" +
        "    \"id\": 11,\n" +
        "    \"title\": \"et ea vero quia laudantium autem\",\n" +
        "    \"body\": \"delectus reiciendis molestiae occaecati non minima eveniet qui voluptatibus\\naccusamus in eum beatae sit\\nvel qui neque voluptates ut commodi qui incidunt\\nut animi commodi\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 2,\n" +
        "    \"id\": 12,\n" +
        "    \"title\": \"in quibusdam tempore odit est dolorem\",\n" +
        "    \"body\": \"itaque id aut magnam\\npraesentium quia et ea odit et ea voluptas et\\nsapiente quia nihil amet occaecati quia id voluptatem\\nincidunt ea est distinctio odio\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 2,\n" +
        "    \"id\": 13,\n" +
        "    \"title\": \"dolorum ut in voluptas mollitia et saepe quo animi\",\n" +
        "    \"body\": \"aut dicta possimus sint mollitia voluptas commodi quo doloremque\\niste corrupti reiciendis voluptatem eius rerum\\nsit cumque quod eligendi laborum minima\\nperferendis recusandae assumenda consectetur porro architecto ipsum ipsam\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"userId\": 2,\n" +
        "    \"id\": 14,\n" +
        "    \"title\": \"voluptatem eligendi optio\",\n" +
        "    \"body\": \"fuga et accusamus dolorum perferendis illo voluptas\\nnon doloremque neque facere\\nad qui dolorum molestiae beatae\\nsed aut voluptas totam sit illum\"\n" +
        "  }" +
        "]"
