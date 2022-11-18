package com.app.breadapp.bootmail;

public class Html {

    public static final String FILE_CONTENT = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\" />\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
            "    <title>Autenticacion Chatbot</title>\n" +
            "    <style type=\"text/css\">\n" +
            "\n" +
            "        .bodisito {\n" +
            "            margin: 0%;\n" +
            "        }\n" +
            "\n" +
            "        @media only screen and (min-width: 801px) {\n" +
            "            .container {\n" +
            "                font-size: 1.4vw;\n" +
            "                margin: 0 auto;\n" +
            "                width: 80%;\n" +
            "                height: 50%;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "        @media only screen and (max-width: 800px) {\n" +
            "            .container {\n" +
            "                font-size: 2.8vw;\n" +
            "                margin: 0 auto;\n" +
            "                width: 100%;\n" +
            "                height: 50%;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .content {\n" +
            "            margin-top: 5%;\n" +
            "            display: flex;\n" +
            "            flex-direction: row;\n" +
            "            font-family: \"Century Gothic\", CenturyGothic, AppleGothic, sans-serif;\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        .tittle {\n" +
            "            color: #09465c;\n" +
            "            text-align: center;\n" +
            "            justify-content: center;\n" +
            "            font-size: 3.5em;\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "        .content>.left {\n" +
            "\n" +
            "            display: flex;\n" +
            "            flex-direction: column;\n" +
            "            justify-content: flex-end;\n" +
            "            align-items: flex-start;\n" +
            "            width: 100%;\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        .content>.left>img {\n" +
            "            width: 100%;\n" +
            "            height: 100%;\n" +
            "        }\n" +
            "\n" +
            "        .content>.right {\n" +
            "\n" +
            "            display: flex;\n" +
            "            flex-direction: column;\n" +
            "            justify-content: space-around;\n" +
            "            align-content: space-around;\n" +
            "            align-items: stretch;\n" +
            "            width: 100%;\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        .banner {\n" +
            "\n" +
            "            text-align: center;\n" +
            "            font-size: 3em;\n" +
            "            color: white;\n" +
            "            background-color: #09465c;\n" +
            "            align-self: auto;\n" +
            "            height: 20%;\n" +
            "            border-radius: 8px 0px 0px 8px;\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        .description {\n" +
            "\n" +
            "            font-size: 1.3em;\n" +
            "            text-align: center;\n" +
            "            justify-content: center;\n" +
            "            vertical-align: center;\n" +
            "            height: 55%;\n" +
            "            color: #231f20;\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        .description>div>b {\n" +
            "            color: #266480;\n" +
            "        }\n" +
            "\n" +
            "        .content>.right>table {\n" +
            "            height: 100%;\n" +
            "        }\n" +
            "\n" +
            "        .footer {\n" +
            "            height: 35%;\n" +
            "            text-align: right;\n" +
            "            position: relative;\n" +
            "            vertical-align: bottom;\n" +
            "            padding: 0;\n" +
            "            background: #17b4e8;\n" +
            "        }\n" +
            "\n" +
            "        .footer .rectangle {\n" +
            "            height: 100%;\n" +
            "            width: 100%;\n" +
            "            border-radius: 0px 0px 90% 0px;\n" +
            "            background: #fff;\n" +
            "        }\n" +
            "\n" +
            "        \n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body class=\"bodisito\">\n" +
            "    <div class=\"container\">\n" +
            "        <div class=\"tittle\"><b>Restablecer contraseña</b></div>\n" +
            "\n" +
            "        <div class=\"content\">\n" +
            "            <div class=\"left\">\n" +
            "                <img src=\"https://breadp-app.vercel.app/assets/img/logo.jpg\">\n" +
            "            </div>\n" +
            "            <div class=\"right\">\n" +
            "                <table>\n" +
            "                    <tr>\n" +
            "                        <td class=\"banner\">\n" +
            "                            <div class=\"link\"><b>[BreadApp]</b></div>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td class=\"description\">\n" +
            "                            <div>Con este enlace podrás restablecer tu contraseña</div>\n" +
            "                            <div><b>[recoverLink]</b></div>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td class=\"footer\">\n" +
            "                            <div class=\"rectangle\">\n" +
            "\n" +
            "                            </div>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                </table>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</body>\n" +
            "\n" +
            "</html>";
}
