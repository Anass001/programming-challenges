package AddressComputer;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class AddressComputer {
    private int[] ipv4Address;
    private int[] subnetMask;

    public void setIpv4Address(String iPv4Address) {
        this.ipv4Address = addressFormatter(iPv4Address);
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = addressFormatter(subnetMask);
    }

    private int[] addressFormatter(String address) {
        int[] newAddress = {0, 0, 0, 0};
        Objects.requireNonNull(address);
        assert address.length() < 16;
        for (int i = 0; i < 4; i++) {
            newAddress[i] = Integer.parseInt(address.substring((i * 3) + i, ((i + 1) * 3) + i));
            assert newAddress[i] < 256;
        }
        return newAddress;
    }

    private String addressFormatter(int[] address) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(address[i]);
            if (i != 3)
                stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }

    private int[] getNetworkAddress() {
        int[] networkAddress = {0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            networkAddress[i] = ipv4Address[i] & subnetMask[i];
        }
        return networkAddress;
    }

    private int[] getBroadcastAddress() {
        // needs generalization to include other types of addresses
        int[] broadcastAddress = getNetworkAddress();
        broadcastAddress[3] = broadcastAddress[3] | 255;
        return broadcastAddress;
    }

    private int[] getFirstHostAddress() {
        int[] firstHostAddress = getNetworkAddress();
        firstHostAddress[3] = firstHostAddress[3] + 1;
        return firstHostAddress;
    }

    private int[] getLastHostAddress() {
        int[] lastHostAddress = getBroadcastAddress();
        lastHostAddress[3] = lastHostAddress[3] - 1;
        return lastHostAddress;
    }

    public void printNetworkInfo() {
        System.out.printf("""
                        IPV4 Address: %s
                        Subnet Mask: %s
                        Network Address: %s
                        Broadcast Address: %s
                        First Host Address: %s
                        Last Host Address: %s
                        """,
                addressFormatter(ipv4Address),
                addressFormatter(subnetMask),
                addressFormatter(getNetworkAddress()),
                addressFormatter(getBroadcastAddress()),
                addressFormatter(getFirstHostAddress()),
                addressFormatter(getLastHostAddress()));
    }

    public static void main(String[] args) {
        AddressComputer addressComputer = new AddressComputer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ipv4 address:");
        addressComputer.setIpv4Address(scanner.nextLine());
        System.out.println("Enter the subnet mast:");
        addressComputer.setSubnetMask(scanner.nextLine());
        addressComputer.printNetworkInfo();
    }
}