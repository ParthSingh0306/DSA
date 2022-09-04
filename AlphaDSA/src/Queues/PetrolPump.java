package Queues;

import java.util.Scanner;

public class PetrolPump {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		petrolpump[] p = new petrolpump[n];
		
		for(int i=0; i<n; i++) {
			p[i] = new petrolpump(sc.nextInt(), sc.nextInt());
		}
		
		System.out.println(DistanceToReachPetrolPump(p, n));
		sc.close();
	}
	
	private static int DistanceToReachPetrolPump(petrolpump[] p, int n) {
		
		int deficit = 0;
		int start = 0;
		int balance = 0;
		
		for(int i=0; i<n; i++) {
			balance += (p[i].petrol - p[i].distance);
			if(balance < 0) {
				deficit += balance;
				start = i + 1;
				balance = 0;
			}
		}
		
		if(deficit + balance >= 0) {
			return start;
		}
		else {
			return -1;
		}
	}

	public static class petrolpump{
		int petrol = 0;;
		int distance = 0;;
		
		petrolpump(int petrol, int distance) {
			this.petrol = petrol;
			this.distance = distance;
		}
	}

}
