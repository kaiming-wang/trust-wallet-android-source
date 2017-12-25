package com.wallet.crypto.trustapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Transaction implements Parcelable {
    @SerializedName("_id")
    public final String hash;
    public final String blockNumber;
    public final long timeStamp;
    public final String nonce;
    public final String blockHash;
    public final String transactionIndex;
    public final String from;
    public final String to;
    public final String value;
    public final String gas;
    public final String gasPrice;
    public final String isError;
    public final String input;
    public final String contractAddress;
    public final String cumulativeGasUsed;
    public final String gasUsed;
    public final String confirmations;
    public final TransactionOperation[] operations;

	public Transaction(
			String blockNumber,
			long timeStamp,
			String hash,
			String nonce,
			String blockHash,
			String transactionIndex,
			String from,
			String to,
			String value,
			String gas,
			String gasPrice,
			String isError,
			String input,
			String contractAddress,
			String cumulativeGasUsed,
			String gasUsed,
			String confirmations,
            TransactionOperation[] operations) {
		this.blockNumber = blockNumber;
		this.timeStamp = timeStamp;
		this.hash = hash;
		this.nonce = nonce;
		this.blockHash = blockHash;
		this.transactionIndex = transactionIndex;
		this.from = from;
		this.to = to;
		this.value = value;
		this.gas = gas;
		this.gasPrice = gasPrice;
		this.isError = isError;
		this.input = input;
		this.contractAddress = contractAddress;
		this.cumulativeGasUsed = cumulativeGasUsed;
		this.gasUsed = gasUsed;
		this.confirmations = confirmations;
		this.operations = operations;
	}

	protected Transaction(Parcel in) {
		blockNumber = in.readString();
		timeStamp = in.readLong();
		hash = in.readString();
		nonce = in.readString();
		blockHash = in.readString();
		transactionIndex = in.readString();
		from = in.readString();
		to = in.readString();
		value = in.readString();
		gas = in.readString();
		gasPrice = in.readString();
		isError = in.readString();
		input = in.readString();
		contractAddress = in.readString();
		cumulativeGasUsed = in.readString();
		gasUsed = in.readString();
		confirmations = in.readString();
        Parcelable[] parcelableArray = in.readParcelableArray(TransactionOperation.class.getClassLoader());
        TransactionOperation[] operations = null;
        if (parcelableArray != null) {
            operations = Arrays.copyOf(parcelableArray, parcelableArray.length, TransactionOperation[].class);
        }
		this.operations = operations;
	}

	public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
		@Override
		public Transaction createFromParcel(Parcel in) {
			return new Transaction(in);
		}

		@Override
		public Transaction[] newArray(int size) {
			return new Transaction[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(blockNumber);
		dest.writeLong(timeStamp);
		dest.writeString(hash);
		dest.writeString(nonce);
		dest.writeString(blockHash);
		dest.writeString(transactionIndex);
		dest.writeString(from);
		dest.writeString(to);
		dest.writeString(value);
		dest.writeString(gas);
		dest.writeString(gasPrice);
		dest.writeString(isError);
		dest.writeString(input);
		dest.writeString(contractAddress);
		dest.writeString(cumulativeGasUsed);
		dest.writeString(gasUsed);
		dest.writeString(confirmations);
		dest.writeParcelableArray(operations, flags);
	}
}
