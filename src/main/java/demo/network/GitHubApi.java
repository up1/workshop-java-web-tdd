package demo.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {

		@GET("users/{name}")
		Call<Github> getData(@Path("name") String name);
}
