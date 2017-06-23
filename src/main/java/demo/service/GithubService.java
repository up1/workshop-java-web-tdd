package demo.service;

import demo.network.GitHubApi;
import demo.network.Github;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubService {
	
	public static void main(String[] args) {
		new GithubService().getDataFromInternet("up1");
	}
	
	public static final String BASE_URL = "https://api.github.com/";
	
	public void getDataFromInternet(String name) {
		Retrofit retrofit = new Retrofit.Builder()
		    .baseUrl(BASE_URL)
		    .addConverterFactory(GsonConverterFactory.create())
		    .build();
		GitHubApi gitHubApi = retrofit.create(GitHubApi.class);
		Call<Github> call = gitHubApi.getData(name);
		call.enqueue(new Callback<Github>() {
			
			public void onResponse(Call<Github> arg0, Response<Github> response) {
				System.out.println(response.body().getName());
			}
			
			public void onFailure(Call<Github> arg0, Throwable arg1) {
				
			}
		});
	}
}
