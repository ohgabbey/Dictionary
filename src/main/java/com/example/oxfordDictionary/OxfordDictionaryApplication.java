package com.example.oxfordDictionary;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;

public class OxfordDictionaryApplication {

	public static void main(String[] args) throws IOException {
		boolean stop = false;

		while(!stop) {
			System.out.print("\nEnter a word: ");
			Scanner sc = new Scanner(System.in);
			String word = sc.nextLine();

			try {
				ObjectMapper mapper = new ObjectMapper();
				OkHttpClient httpClientDict = new OkHttpClient();
				String oxfordDictionaryURL = "https://od-api.oxforddictionaries.com/api/v1/entries/en/" + word;
				Request request = new Request.Builder()
						.url(oxfordDictionaryURL)
						.header("app_key", "428ccfe0c93dfc13b44c70d161d0b942")
						.header("app_id", "87664e14")
						.build();
				Call call = httpClientDict.newCall(request);

				try (Response response = call.execute()) {
					String respBodyStr = response.body().string();
					DictionaryFields dictFields = mapper.readValue(respBodyStr, DictionaryFields.class);
				} catch (NullPointerException e) {
					System.out.println("Oxford Dictionary did not return anything.");
				}
			} catch (JsonParseException e) {
				System.out.println("The word you entered does not exist in the English Oxford Dictionary..");
			}
			System.out.print("\nDo you want to exit the program? Y/N? ");
			String exit = sc.nextLine();
			stop = exit.equals("Y") || exit.equals("y");
		}
	}
}
