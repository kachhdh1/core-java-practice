package com.dk.azure;

import java.io.FileWriter;
import java.io.IOException;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;

public class First {

	public static void main(String[] args) throws IOException {
		//System.out.println(System.getenv("DK_VAR1"));

		String connectStr = "dp200gen2storage;AccountKey=4K2IS0yVzXLm0KmB3gG3CKL00O9t9+7QrTvoocZDTpxiac66CPtsbufx6sK0wsrBhIAD0SVHqbveNQa0xpl0Vw==;EndpointSuffix=core.windows.net";
		
		// Create a BlobServiceClient object which will be used to create a container client
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();

		//Create a unique name for the container
		String containerName = "quickstartblobs" + java.util.UUID.randomUUID();

		// Create the container and return a container client object
		BlobContainerClient containerClient = blobServiceClient.createBlobContainer(containerName);
		
		// Create a local file in the ./data/ directory for uploading and downloading
		String localPath = "D:\\upload\\dharmik\\dp200\\tmp\\";
		String fileName = "quickstart" + java.util.UUID.randomUUID() + ".txt";

		// Write text to the file
		FileWriter writer = new FileWriter(localPath + fileName, true);
		writer.write("Hello, World!");
		writer.close();

		// Get a reference to a blob
		BlobClient blobClient = containerClient.getBlobClient(fileName);

		System.out.println("\nUploading to Blob storage as blob:\n\t" + blobClient.getBlobUrl());

		// Upload the blob
		blobClient.uploadFromFile(localPath + fileName);
		
		System.out.println("\nListing blobs...");

		// List the blob(s) in the container.
		for (BlobItem blobItem : containerClient.listBlobs()) {
		    System.out.println("\t" + blobItem.getName());
		}
	}

}
