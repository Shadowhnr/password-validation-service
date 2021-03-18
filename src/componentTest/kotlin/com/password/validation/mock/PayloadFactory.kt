package com.password.validation.mock

object PayloadFactory {
    fun validPasswordPayload() = """
        { 
            "password": "AbTp9!fok" 
        }
        """.trim()

    fun emptyPasswordPayload() = """
        { 
            "password": "" 
        }
        """.trim()

    fun withoutDigitPasswordPayload() = """
        { 
            "password": "abc" 
        }
        """.trim()

    fun withoutLowerCasePasswordPayload() = """
        { 
            "password": "ABC" 
        }
        """.trim()

    fun withoutSpecialCharacterPasswordPayload() = """
        { 
            "password": "AbTp9fok" 
        }
        """.trim()

    fun withRepeatedCharactersPasswordPayload() = """
        { 
            "password": "AbTp9!foA" 
        }
        """.trim()

    fun withSpacesPasswordPayload() = """
        { 
            "password": "AbTp9!fok " 
        }
        """.trim()
}