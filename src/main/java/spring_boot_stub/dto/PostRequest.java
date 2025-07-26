package spring_boot_stub.dto;

public record PostRequest(
        String name,
        String surname,
        Integer age
) {}