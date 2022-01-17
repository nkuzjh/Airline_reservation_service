package com.air.airbooking.config;


/**
 * @Author: 星期八领证
 * @Date: 2021/1/20 14:35
 * @Content: AliPayConfig
 */
public class AliPayConfig {

    public static String app_id =  "2016101600702747";

    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC6GtfweYp3qvgrxabPfMULBScf0lVNAt9xqaHunSddlI/SX1Y/Hl+jtEWCLM/NgulSwBcots0VEJP54bqUTU9kCg4kFbvNM5ptUaIk1BtV+046KUTkgbF+UH2GkwlMO1oNToBhFauFb8MOQdyCtBg/6s8mEdZVWrHOIwQUZ9QuzakWAoESpgQnUa1aiUGw8NFeFklI65K6k83+yEdrR9p3Eghz0VANONVBEfvCsad0YruCc37Yb9Vpvwy61N6ws+zLzBeEUfd2Kk3oig1GB+MOZ46TrMYsISONWMOYV2aE+2GVeu3MimB4Ufu2NjzvtYrjuXdTs+Kv9j4AxmhBvy5DAgMBAAECggEBAJqvBRzTaMveRzfaqLN8uSpXthU09cF0ydPncrip1rZpbMEmjMEZtdSTWdLA/FeMn/IvxxAIIJ2JkfT4MeRh/cLguLA1gEsmwQxr9aE2yyHEJ1kgRCrJwYWD0VGxlODP1CGLRhlrsYzPQAjxpR7eIem+eT7jRIrdPzxezl1Hj4z15u3GQzhsFdOM8HmjNRW9/XAeePwwMUjNeFbpG56Bh6t1GKN/scirTzDOF5guw90CcKGshqVk0eypz0jEdgZ8kmuylPLHw07jIOKwlNdLynmoc0zMNg0jkLvsFUAtgJuMLZsEy+9ag9UZYBrZ6a1KkzGlz5qqcVHhgbaUFymmWwECgYEA8i1/XWZPoAqfFG/OPPJO7Occ6tLnl5EQZvroIjwQSZjx6mUmZ1gBaRhD0UwIJ6bPMlw9h/gVXR2dMpMy+AujGF2t9eiPaIfA0ENxGxBkplauzmaC2cRd7O1UZEzIMCerGWvatL1pmPI6hiIIr1HWHEKgJT7VIqSlBqtqMdO3CLECgYEAxLoOIcMMq8Y1+yCz9MyHaLQNI9WVFLlA7M2nSUeX77PEvJowiuaiDJFWrgZKn0q1RYetJXNOEOXZm/TvBMiyHjHdAn2CdsM4WinPG3RPMuqwmzswmjYWw7rqAtLIsed/r8jW0a9DINtWfEnzjo9z+g7NmAKgNQbUc5BcVgWsYzMCgYAPCT4gKWsGL8KivTJb3FuEH/FOrxuL8IjJLAjfn0UPnLxgZjlVL0SfJs+HHiZfd97jbJCxcXi6GE2bR0Jh3i8ZIy/a1b6ZqdwR0i4ilQj6vuUJkZnMNYHzZOTZeV7whnX8FRM2J5B324pAq7pIUFdv178jsNwA06IfYOMuBswVcQKBgGih8KxCWrXuGX31GeHE+uxUf3ykt8Mq+P46L5SJMKV8PtJ1TAZEvsHid3DdxcjNanaNwCjgGBBiwAf0EUDBIgNvT/ZoHQDfulQyUoZuqUUSkFYv+By9UgROoPJZfAcrcr1jG+awygpqvqgiiRk08WF5iB4mn2E0vcCtcn8KS3MDAoGAHpBnq91jFb21gZZTG5GqYf0KE+iUKgbJ+o9Eetmbre6JNbmzA8DglgtjuufqfoztV6E89mQofy6ukibwZGBHCGQ+ZKcn2QrGHtvEq6ywDZnCGHvVsfT6JdTN3GNGOkwDD77b6ap740pOEI4xEZYMM49tu6Ma0CI7zv4MERdnNoM=";

    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtcazLDtNwOGVh7MG9WIGszjXk3eonn2j6eVWrrE+cZdhVUpYkV2FP5pNmAg0f2VaiXatjVsNlnUpk53AppRhzrydNTYgbwpyQ3WW+bnrQj+5DNk10R8o3pO6PWs8T/b4TG5/bIIeHbjTUHs7AMO7Dyz/PcmCk0KeX9BMg8dxmXrr/SD/Tc+80L4gBVv52sCjDvsApGlU19C2giGxdWd59EQ1p1hWjCd9L+I1hT1+IECu4eGTvmJQpV4W+L9L49pmu1j7x3VTA0Wd4aBvlQNZfjxP+1LVJ9mlBeqyvv9QJiLL7Y/NpLSqZsfE3IdUnQxv4SuXSWSJyYJPDVmxsa9cEwIDAQAB";

    public static String notify_url = "http://127.0.0.1:1234/notifyUrl";

    public static String return_url = "http://127.0.0.1:1234/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
