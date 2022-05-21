package com.fbn.core.util

import org.springframework.stereotype.Component

@Component
class MailTemplateUtil {

    fun creditNotification(input : HashMap<String, String>) : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title> Credit Notification</title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
            <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 400px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                <tr>
                    <td style="padding-left: 1em; padding-top: 1em;">
                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                    </td>
                </tr>

                <tr>
                    <td>
                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                            <tr>
                                <td align="center" style="padding-top: 2em;">
                                    <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/transaction-notification.png" alt="transaction-notification" width="170" height="152" style="width: 170px; height: 152px;">
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 14px; line-height: 20px; color: #182D4C; font-weight: 800; margin-top: 12px; margin-bottom:4px;">Dear Amara</p>
                                    <p style="font-size: 13px; line-height: 17px; font-weight: 400; margin-top: 0px;"> This is a transaction notification on your account</p>
                                </td>
                            </tr>

                            <tr>
                                <td style="padding: 0px 20px 0px 20px">
                                    <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 3px ; margin-bottom: 5px ;"></p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0" width="450px">
                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 4em;">
                                                <p style="margin-bottom: 6px;">Account Number:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 2em; ">
                                                <p style="margin-bottom: 6px;">${input["accountno"]}</p>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 4em;  ">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">Amount:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 2em;">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">${input["amount"]} CR</p>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 4em;  ">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">Transaction Narrative:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 2em;">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">${input["narration"]}CONF</p>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 4em;  ">
                                                <p style="margin-top: 2px; ">Transaction Date:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 2em;">
                                                <p style="margin-top: 2px; ">${input["transdate"]}</p>
                                            </td>
                                        </tr>

                                    </table>
                                </td>
                            </tr>

                            <tr>
                                <td style="padding: 0px 20px 0px 20px">
                                    <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 3px ; margin-bottom: 2px ;"></p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0" width="450px">
                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 2em; ">
                                                <p style="margin-bottom: 6px;">Cleared Balance:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 1em; ">
                                                <p style="margin-bottom: 6px;">${input["clearedbalance"]}CR</p>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 2em; ">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">Uncleared Balance:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 1em;">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">${input["unclearedbalance"]} CR</p>
                                            </td>
                                        </tr>


                                    </table>
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 50px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                    <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank </p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                        <tr>
                                            <td style="font-size:10px;text-align:center;background-color: ; ">
                                                <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                    <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>


                                                    <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                            <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                            <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                    <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                            <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                </p>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>


                        </table>
                    </td>
                </tr>
            </table>

            </body>
            </html>
        """.trimIndent()
    }

    fun debitNotification(input: HashMap<String, String>)  : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title> Credit Notification</title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
            <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 400px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                <tr>
                    <td style="padding-left: 1em; padding-top: 1em;">
                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                    </td>
                </tr>

                <tr>
                    <td>
                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                            <tr>
                                <td align="center" style="padding-top: 2em;">
                                    <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/transaction-notification.png" alt="transaction-notification" width="170" height="152" style="width: 170px; height: 152px;">
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 14px; line-height: 20px; color: #182D4C; font-weight: 800; margin-top: 12px; margin-bottom:4px;">Dear Amara</p>
                                    <p style="font-size: 13px; line-height: 17px; font-weight: 400; margin-top: 0px;"> This is a transaction notification on your account</p>
                                </td>
                            </tr>

                            <tr>
                                <td style="padding: 0px 20px 0px 20px">
                                    <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 3px ; margin-bottom: 5px ;"></p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0" width="450px">
                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 4em;">
                                                <p style="margin-bottom: 6px;">Account Number:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 2em; ">
                                                <p style="margin-bottom: 6px;">${input["accountno"]}</p>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 4em;  ">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">Amount:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 2em;">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">${input["amount"]} DR</p>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 4em;  ">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">Transaction Narrative:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 2em;">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">${input["narration"]}CONF</p>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 4em;  ">
                                                <p style="margin-top: 2px; ">Transaction Date:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 2em;">
                                                <p style="margin-top: 2px; ">${input["transdate"]}</p>
                                            </td>
                                        </tr>

                                    </table>
                                </td>
                            </tr>

                            <tr>
                                <td style="padding: 0px 20px 0px 20px">
                                    <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 3px ; margin-bottom: 2px ;"></p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0" width="450px">
                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 2em; ">
                                                <p style="margin-bottom: 6px;">Cleared Balance:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 1em; ">
                                                <p style="margin-bottom: 6px;">${input["clearedbalance"]}CR</p>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-left: 2em; ">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">Uncleared Balance:</p>
                                            </td>

                                            <td align="center" style="font-size: 12px; line-height: 18px; color: #182D4C; font-weight: 400; padding-right: 1em;">
                                                <p style="margin-top: 2px; margin-bottom: 6px; ">${input["unclearedbalance"]} CR</p>
                                            </td>
                                        </tr>


                                    </table>
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 50px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                    <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank </p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                        <tr>
                                            <td style="font-size:10px;text-align:center;background-color: ; ">
                                                <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                    <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>


                                                    <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                            <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                            <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                    <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                            <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                </p>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>


                        </table>
                    </td>
                </tr>
            </table>

            </body>
            </html>
        """.trimIndent()
    }

    fun loginNotification(input: HashMap<String, String>) : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title> Login</title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
                <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 100px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                    <tr>
                        <td style="padding-left: 1em; padding-top: 1em;">
                            <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin:.5em 2em 4em 2em;">
                               <tr>
                                   <td align="center" style="padding-top: 2em;">
                                       <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/login.png" alt="login" width="246" height="172" style="width: 246px; height: 172px;">
                                   </td>
                               </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800;">SUCCESSFUL LOGIN</p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400;">Dear ${input["name"]},<br>
                                            Please be informed that your FBNBank Account was<br>
                                            accessed at <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400; "> ${input["timestamp"]}</span>.
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400; margin-bottom: 0px;">
                                            If you did not log on to your FBNBank profile at the<br>
                                            time detailed above, please call us on: <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400; "> +233 302 739011,</span><br>
                                            <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400; ">+233 302 739011,</span> or send an email to <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400; ">ghcomplaint@fbnbankghana.com</span><br>
                                            immediately
                                        </p>

                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px; ">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 30px ; margin-bottom: 50px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                        <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank </p>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                            <tr>
                                                <td style="font-size:10px;text-align:center;background-color: ; ">
                                                    <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                        <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>


                                                        <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                                <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                                <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                        <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                                <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                </table>

            </body>
            </html>
        """.trimIndent()
    }

    fun adminNotification() : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Admin Notification</title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
                <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 100px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                    <tr>
                        <td style="padding-left: 1em; padding-top: 1em;">
                            <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin:.5em 2em 4em 2em;">
                               <tr>
                                   <td align="center" style="padding-top: 2em;">
                                       <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/login.png" alt="login" width="246" height="172" style="width: 246px; height: 172px;">
                                   </td>
                               </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800;">SUCCESSFUL LOGIN</p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400;">Dear Admin,<br>
                                            Please be informed that there is an item waiting for approval on your queue.
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400; margin-bottom: 0px;">
                                            If you are not a FBNBank admin or received this email by mistake.<br>
                                            please call us on: <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400; "> +233 302 739011,</span><br>
                                            or send an email to <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400; ">ghcomplaint@fbnbankghana.com</span><br>
                                            immediately
                                        </p>

                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px; ">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 30px ; margin-bottom: 50px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                        <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank </p>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                            <tr>
                                                <td style="font-size:10px;text-align:center;background-color: ; ">
                                                    <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                        <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>


                                                        <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                                <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                                <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                        <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                                <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                </table>

            </body>
            </html>
        """.trimIndent()
    }

    fun otpNotification(input: HashMap<String, String>) : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title> OTP notification </title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
                <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 400px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                    <tr>
                        <td style="padding-left: 1em; padding-top: 1em;">
                            <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                                <tr>
                                    <td align="center" style="padding-top: 2.5em;">
                                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/otp.png" alt="otp" width="114" height="80" style="width: 114px; height: 80px;">
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800; margin-top: 26px; margin-bottom: 0px;">Dear ${input["name"]}</p>
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400; margin-top: 6px; margin-bottom: 0px;">The OTP for your transaction is:</p>
                                        <p style="font-size: 16px; line-height: 20px; font-weight: 400; margin-top: 6px;">${input["otp"]}</p>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 0px ; margin-bottom: 2px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400; margin-top: 5px; margin-bottom: 8px;">This OTP expires in 10 minutes.<br>
                                            If you did not firstapple this, <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400;">please contact us immediately</span></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 3px ; margin-bottom: 2px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 60px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                        <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank </p>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                            <tr>
                                                <td style="font-size:10px;text-align:center;background-color: ; ">
                                                    <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                        <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>


                                                        <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                                <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                                <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                        <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                                <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </body>
            </html>
        """.trimIndent()
    }

    fun statementsNotification(input: HashMap<String, String>) : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title> OTP notification </title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
                <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 400px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                    <tr>
                        <td style="padding-left: 1em; padding-top: 1em;">
                            <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                                <tr>
                                    <td align="center" style="padding-top: 2.5em;">
                                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/otp.png" alt="otp" width="114" height="80" style="width: 114px; height: 80px;">
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800; margin-top: 26px; margin-bottom: 0px;">Dear ${input["name"]}</p>
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400; margin-top: 6px; margin-bottom: 0px;">As requested, kindly find attached statement of your account from ${input["startdate"]} to ${input["enddate"]}</p>
                                        <p style="font-size: 16px; line-height: 20px; font-weight: 400; margin-top: 6px;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 0px ; margin-bottom: 2px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400; margin-top: 5px; margin-bottom: 8px;">If you did not firstapple for this statement<br>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 3px ; margin-bottom: 2px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 60px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                        <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank </p>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                            <tr>
                                                <td style="font-size:10px;text-align:center;background-color: ; ">
                                                    <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                        <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>


                                                        <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                                <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                                <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                        <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                                <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </body>
            </html>
        """.trimIndent()
    }

    fun otpOfficerNotification(input: HashMap<String, String>) : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title> OTP notification </title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
                <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 400px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                    <tr>
                        <td style="padding-left: 1em; padding-top: 1em;">
                            <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                                <tr>
                                    <td align="center" style="padding-top: 2.5em;">
                                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/otp.png" alt="otp" width="114" height="80" style="width: 114px; height: 80px;">
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800; margin-top: 26px; margin-bottom: 0px;">Dear ${input["name"]}</p>
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400; margin-top: 6px; margin-bottom: 0px;">You have been profiled as an officer.</p>
                                        <p style="font-size: 12px; line-height: 20px; font-weight: 400; margin-top: 6px;">Username: ${input["email"]}</p>
                                        <p style="font-size: 12px; line-height: 20px; font-weight: 400; margin-top: 6px;">Password: ${input["name"]}${input["otp"]}</p>
                                        <p style="font-size: 12px; line-height: 20px; font-weight: 400; margin-top: 6px;"><a href="https://196.11.150.250" target="_blank">Activate your account</a></p>
                                        <p style="font-size: 16px; line-height: 20px; font-weight: 400; margin-top: 6px;">You will be prompted to change your password on first login.</p>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 0px ; margin-bottom: 2px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400; margin-top: 5px; margin-bottom: 8px;"><br>
                                            If you did not firstapple this, <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400;">please contact us immediately</span></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 3px ; margin-bottom: 2px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 60px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                        <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank</p>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                            <tr>
                                                <td style="font-size:10px;text-align:center;background-color: ; ">
                                                    <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                        <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>


                                                        <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                                <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                                <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                        <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                                <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </body>
            </html>
        """.trimIndent()
    }

    fun passwordChangeNotification(input: HashMap<String, String>) : String{
        return  """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title> Password Update</title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
                <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 100px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em; font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                    <tr>
                        <td style="padding-left: 1em; padding-top: 1em;">
                            <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                                <tr>
                                    <td align="center" style="padding-top: 2em;">
                                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/password-update.png" alt="password-update" width="164" height="174" style="width: 164px; height: 174px;">
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800; margin-top: 26px;"> YOUR PASSWORD HAS BEEN UPDATED</p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800; margin-bottom:3px;">Dear ${input["name"]}</p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; font-weight: 400;">
                                            Your password was changed recently.<br>
                                            If you did not change your password, please let us know<br>
                                            as soon as possible at <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400; ">ghcomplaint@fbnbankghana.com</span>
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 16px ; margin-bottom: 50px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 20px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                        <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank </p>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                            <tr>
                                                <td style="font-size:10px;text-align:center;background-color: ; ">
                                                    <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                        <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>


                                                        <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                                <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                                <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                        <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                                <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </body>
            </html>
        """.trimIndent()
    }

    fun welcomeNotification(input: HashMap<String, String>) : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Welcome </title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
                <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 100px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                    <tr>
                        <td style="padding-left: 1em; padding-top: 1em;">
                            <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style=" background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin:.5em 2em 4em 2em;">
                                <tr>
                                    <td align="center" style="padding-top: 3em;">
                                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/welcome.png" alt="welcome" width="244" height="134" style="width: 244px; height: 134px;">
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 30px; color: #182D4C; font-weight: 800;">${input["name"]},</p>
                                        <p style="font-size: 12px; line-height: 18px; margin-top:0px; margin-bottom: 3px; color: #182D4C; font-weight: 800;">WELCOME TO FBNBank</p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 13px; line-height: 19px; color: #182D4C; font-weight: 400;">You’re now a part of a community that experiences 21st century<br>
                                            banking. Perform all your transactions and view all account activities<br>
                                            on the new an improved Corporate Internet Banking.</p>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding: 0px 20px 0px 20px">
                                        <p style="border: .5px solid rgba(24,45,76,0.14); width: 100%; margin-top: 20px ; margin-bottom: 50px ;"></p>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                        <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank </p>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                            <tr>
                                                <td style="font-size:10px;text-align:center;background-color: ; ">
                                                    <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                        <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>


                                                        <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.50021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.50021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                                <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                                <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                        <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                                <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.50018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>

                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                </table>
            </body>
            </html>
        """.trimIndent()
    }

    fun batchNotification(input: HashMap<String, Any?>) : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Authorization Notification</title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
            <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 400px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                <tr>
                    <td style="padding-left: 1em; padding-top: 1em;">
                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                    </td>
                </tr>

                <tr>
                    <td>
                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                            <tr>
                                <td align="center" style="padding-top: 2em;">
                                    <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/account-statement.png" alt="account-statement" width="214" height="120" style="width: 214px; height: 120px">
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800; margin-top: 26px; margin-bottom:3px;">Hello ${input["name"]},</p>
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size:12px; line-height: 18px; font-weight:400;">
                                        A transaction was pushed to your queue for authorization on<br>
                                         <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400;"> ${input["date"]}</span><br>
                                         Please login to the CIB Platform to authorize your pending transactions. 
                                    </p>
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 60px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                    <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank </p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                        <tr>
                                            <td style="font-size:10px;text-align:center;background-color: ; ">
                                                <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                    <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>


                                                    <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                            <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                            <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                    <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                            <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                </p>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

            </table>
            </body>
            </html>
        """.trimIndent()
    }

    fun batchAuthNotification(input: HashMap<String, String>) : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Authorization Notification</title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
            <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 400px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                <tr>
                    <td style="padding-left: 1em; padding-top: 1em;">
                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                    </td>
                </tr>

                <tr>
                    <td>
                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                            <tr>
                                <td align="center" style="padding-top: 2em;">
                                    <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/account-statement.png" alt="account-statement" width="214" height="120" style="width: 214px; height: 120px">
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800; margin-top: 26px; margin-bottom:3px;">Hello ${input["name"]},</p>
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size:12px; line-height: 18px; font-weight:400;">
                                            A transaction batch initially pushed for authorization has finally been released the processing on <br>
                                         <span style="font-size: 12px; line-height:18px; color:#F8A700; font-weight:400;"> ${input["date"]}</span><br>
                                         Please login to the CIB Platform to see other unauthorized batches.
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 60px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                    <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank  </p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                        <tr>
                                            <td style="font-size:10px;text-align:center;background-color: ; ">
                                                <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                    <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>


                                                    <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                            <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                            <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                    <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                            <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                </p>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

            </table>
            </body>
            </html>
        """.trimIndent()
    }


    fun batchDeclineNotification(input: HashMap<String, String>) : String{
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Authorization Notification</title>
                <meta name="viewport" content="width=device-width,initial-scale=1.0">
            </head>
            <body>
            <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 400px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                <tr>
                    <td style="padding-left: 1em; padding-top: 1em;">
                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                    </td>
                </tr>

                <tr>
                    <td>
                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                            <tr>
                                <td align="center" style="padding-top: 2em;">
                                    <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/account-statement.png" alt="account-statement" width="214" height="120" style="width: 214px; height: 120px">
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800; margin-top: 26px; margin-bottom:3px;">Hello ${input["name"]},</p>
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size:12px; line-height: 18px; font-weight:400;">
                                            A transaction batch initially pushed for authorization has finally been declined s<br>
                                            Please logon to the CIB Platform to see authorized batches
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 60px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                    <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank  </p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                        <tr>
                                            <td style="font-size:10px;text-align:center;background-color: ; ">
                                                <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                    <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>


                                                    <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                            <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                            <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                            <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                    <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                        <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                            <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                            <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                        </svg>
                                                    </a>

                                                </p>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

            </table>
            </body>
            </html>
        """.trimIndent()
    }


    fun batchCountAuthNotification(input: HashMap<String, String>) : String{
            return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Authorization Notification</title>
                    <meta name="viewport" content="width=device-width,initial-scale=1.0">
                </head>
                <body>
                <table  align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="border-collapse: collapse; height: 400px; background: url('');  background-color: #F2F4F7; margin-top: 2em; margin-bottom: 2em;  font-family: Tahoma,'Helvetica Neue',Helvetica,Arial,sans-serif;">
                    <tr>
                        <td style="padding-left: 1em; padding-top: 1em;">
                            <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/logo.png" alt="logo" width="170" height="48" style="width: 170px; height: 48px;">
                        </td>
                    </tr>
    
                    <tr>
                        <td>
                            <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="background: url('https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/background.png'); background-size: cover; background-position: center center; background-color: white; margin: .5em 2em 4em 2em;">
                                <tr>
                                    <td align="center" style="padding-top: 2em;">
                                        <img src="https://assets-base.s3.amazonaws.com/img/firstbank/first-mobile/account-statement.png" alt="account-statement" width="214" height="120" style="width: 214px; height: 120px">
                                    </td>
                                </tr>
    
                                <tr>
                                    <td align="center">
                                        <p style="font-size: 14px; line-height: 18px; color: #182D4C; font-weight: 800; margin-top: 26px; margin-bottom:3px;">Hello ${input["name"]},</p>
                                    </td>
                                </tr>
    
                                <tr>
                                    <td align="center">
                                        <p style="font-size:12px; line-height: 18px; font-weight:400;">
                                                A transaction batch initially pushed for authorization has been approved by an officer<br>
                                                Count: ${input["count"]} of ${input["orgcount"]}<br>
                                                Please logon to the CIB Platform to see authorized batches
                                    </td>
                                </tr>
    
                                <tr>
                                    <td align="center">
                                        <p style="font-size: 12px; line-height: 18px; margin-bottom: 0px; margin-top: 60px; color: #182D4C; font-weight: 400;">Thank you for banking with</p>
                                        <p style="font-size: 12px; line-height: 18px; margin-top: 0px; color: #182D4C; font-weight: 800; margin-bottom: 5px;"> FBNBank  </p>
                                    </td>
                                </tr>
    
                                <tr>
                                    <td>
                                        <table align="center" border="0" cellpadding="0" cellspacing="0" width="450px" style="">
                                            <tr>
                                                <td style="font-size:10px;text-align:center;background-color: ; ">
                                                    <p style="margin-top: 3px;margin-bottom: 50px;padding-top: 10px;">
                                                        <a href="https://www.facebook.com/firstbankgh/" style="padding-right: .8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.70001C15.4 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23969 15.3967 7.69145 15.5492 6.19779 15.252C4.70414 14.9549 3.33215 14.2216 2.25529 13.1447C1.17842 12.0679 0.445064 10.6959 0.147958 9.20221C-0.149149 7.70856 0.00333416 6.16035 0.586129 4.75336C1.16892 3.34637 2.15584 2.14379 3.4221 1.2977C4.68836 0.451612 6.17707 0 7.69999 0C9.74216 0 11.7007 0.811249 13.1447 2.25528C14.5888 3.69931 15.4 5.65785 15.4 7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M6.45477 12.7693H8.43176V7.81427H9.81177L9.95874 6.15625H8.43176V5.21423C8.43176 4.82323 8.50973 4.66827 8.88873 4.66827H9.95874V2.94727H8.58978C7.11778 2.94727 6.45477 3.59524 6.45477 4.83624V6.15826H5.42578V7.83728H6.45477V12.7693Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>
    
    
                                                        <a href="https://www.instagram.com/fbnbbankgh/" target="_blank" style="color: transparent; padding-right: .8em;">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4001 7.70001C15.4001 9.22293 14.9484 10.7116 14.1023 11.9779C13.2562 13.2442 12.0537 14.2311 10.6467 14.8139C9.23973 15.3967 7.6914 15.5492 6.19775 15.252C4.70409 14.9549 3.33223 14.2216 2.25536 13.1447C1.1785 12.0678 0.445048 10.6959 0.147942 9.20221C-0.149164 7.70856 0.0033794 6.16035 0.586174 4.75336C1.16897 3.34637 2.15585 2.14379 3.42211 1.2977C4.68837 0.451612 6.17703 0 7.69994 0C9.74211 0 11.7007 0.811249 13.1448 2.25528C14.5888 3.69931 15.4001 5.65785 15.4001 7.70001V7.70001Z" fill="#F2F4F7"></path>
                                                                <path d="M7.70483 4.21021C8.89483 4.21021 9.03488 4.21021 9.50488 4.23621C9.78728 4.23944 10.0669 4.29114 10.3318 4.38916C10.5239 4.46325 10.6985 4.57671 10.8442 4.72223C10.9899 4.86775 11.1034 5.04215 11.1777 5.23419C11.2755 5.49913 11.3273 5.77879 11.3308 6.06116C11.3518 6.53016 11.3569 6.67121 11.3569 7.86121C11.3569 9.05121 11.3568 9.19119 11.3308 9.66119C11.3273 9.94356 11.2754 10.2232 11.1777 10.4882C11.1034 10.6802 10.9897 10.8545 10.844 11.0001C10.6983 11.1456 10.5239 11.259 10.3318 11.3332C10.0669 11.4312 9.78728 11.483 9.50488 11.4862C9.03488 11.5072 8.89483 11.5122 7.70483 11.5122C6.51483 11.5122 6.37479 11.5122 5.90479 11.4862C5.62239 11.4829 5.34276 11.4312 5.07788 11.3332C4.88447 11.2619 4.70955 11.1481 4.56592 11.0002C4.41764 10.8569 4.30378 10.6818 4.23291 10.4882C4.13465 10.2233 4.08251 9.94364 4.07886 9.66119C4.05786 9.19119 4.05273 9.05021 4.05273 7.86121C4.05273 6.67221 4.05286 6.53116 4.07886 6.06116C4.08247 5.77871 4.13461 5.49901 4.23291 5.23419C4.30381 5.04056 4.41767 4.86549 4.56592 4.72217C4.70957 4.57432 4.88448 4.46053 5.07788 4.38916C5.34275 4.29118 5.62239 4.23947 5.90479 4.23621C6.37379 4.21521 6.51483 4.21021 7.70483 4.21021V4.21021ZM7.70483 3.41016C6.49583 3.41016 6.3439 3.41519 5.8689 3.43719C5.49945 3.44456 5.13388 3.51453 4.78784 3.64417C4.49263 3.75848 4.22458 3.93313 4.00073 4.15698C3.77688 4.38083 3.60211 4.64894 3.48779 4.94415C3.35801 5.29014 3.28798 5.65574 3.28076 6.02521C3.25876 6.45021 3.25391 6.65221 3.25391 7.86121C3.25391 9.07021 3.25876 9.2222 3.28076 9.6972C3.288 10.0667 3.35802 10.4322 3.48779 10.7782C3.60205 11.0734 3.77663 11.3416 4.00049 11.5654C4.22435 11.7893 4.4926 11.9639 4.78784 12.0782C5.13388 12.2078 5.49945 12.2778 5.8689 12.2852C6.3439 12.3072 6.49583 12.3122 7.70483 12.3122C8.91383 12.3122 9.06675 12.3072 9.54175 12.2852C9.91121 12.2779 10.2768 12.2079 10.6228 12.0782C10.9181 11.964 11.1863 11.7894 11.4102 11.5655C11.634 11.3416 11.8086 11.0735 11.9229 10.7782C12.0525 10.4322 12.1226 10.0667 12.1299 9.6972C12.1519 9.2222 12.1567 9.07021 12.1567 7.86121C12.1567 6.65221 12.1569 6.45021 12.1299 6.02521C12.1226 5.65575 12.0526 5.29017 11.9229 4.94415C11.8086 4.64891 11.634 4.38078 11.4102 4.15692C11.1863 3.93306 10.918 3.75843 10.6228 3.64417C10.2768 3.51443 9.91121 3.44447 9.54175 3.43719C9.06675 3.41519 8.91483 3.41016 7.70483 3.41016Z" fill="#182D4C"></path>
                                                                <path d="M7.70288 5.57422C7.25056 5.57422 6.80847 5.70836 6.43238 5.95966C6.05628 6.21095 5.76319 6.56813 5.59009 6.98602C5.41699 7.40392 5.37172 7.86374 5.45996 8.30737C5.54821 8.75101 5.76585 9.15855 6.0857 9.47839C6.40554 9.79824 6.81321 10.016 7.25684 10.1042C7.70047 10.1925 8.16023 10.1472 8.57813 9.97412C8.99602 9.80102 9.3532 9.50787 9.6045 9.13177C9.85579 8.75568 9.98999 8.31353 9.98999 7.86121C9.98999 7.56087 9.93085 7.26349 9.81592 6.98602C9.70099 6.70855 9.53244 6.45645 9.32007 6.24408C9.1077 6.03171 8.8556 5.86322 8.57813 5.74829C8.30066 5.63336 8.00322 5.57422 7.70288 5.57422ZM7.70288 9.34619C7.40922 9.34599 7.12225 9.25875 6.87818 9.09546C6.6341 8.93216 6.44403 8.7002 6.33179 8.42883C6.21955 8.15747 6.19015 7.85886 6.24756 7.57086C6.30497 7.28287 6.44658 7.01837 6.6543 6.81079C6.86202 6.60321 7.12652 6.46188 7.41455 6.40466C7.70259 6.34745 8.00117 6.37689 8.27246 6.48932C8.54375 6.60174 8.7756 6.79213 8.93872 7.03632C9.10185 7.2805 9.18897 7.56754 9.18897 7.86121C9.18897 8.0563 9.15062 8.24951 9.07593 8.42975C9.00124 8.60998 8.89167 8.77371 8.75367 8.91162C8.61567 9.04953 8.45177 9.15889 8.27149 9.23346C8.0912 9.30803 7.89798 9.34632 7.70288 9.34619Z" fill="#182D4C"></path>
                                                                <path d="M10.6168 5.48419C10.6166 5.58972 10.5852 5.69286 10.5265 5.78052C10.4677 5.86818 10.3842 5.93645 10.2867 5.97675C10.1892 6.01704 10.0819 6.02753 9.97836 6.0069C9.87487 5.98626 9.77979 5.9354 9.70516 5.86078C9.63054 5.78616 9.57981 5.69114 9.55917 5.58765C9.53853 5.48415 9.5489 5.37683 9.5892 5.2793C9.62949 5.18176 9.69782 5.09837 9.78549 5.03961C9.87315 4.98086 9.97634 4.94942 10.0819 4.94922C10.1522 4.94909 10.2217 4.96285 10.2867 4.98969C10.3517 5.01653 10.4108 5.05589 10.4605 5.10559C10.5102 5.1553 10.5497 5.21433 10.5765 5.2793C10.6033 5.34427 10.6169 5.4139 10.6168 5.48419" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>
    
                                                        <a href="https://twitter.com/FBNBankGh" style="padding-right:.8em;color: transparent;" target="_blank">
                                                            <svg width="30" height="30" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M15.4 7.69995C15.4 9.22287 14.9484 10.7115 14.1024 11.9778C13.2563 13.244 12.0535 14.2309 10.6465 14.8137C9.23955 15.3965 7.69146 15.5491 6.19781 15.252C4.70416 14.9548 3.33205 14.2216 2.25518 13.1448C1.17832 12.0679 0.445111 10.6958 0.148005 9.20215C-0.149101 7.70849 0.00319839 6.16041 0.585993 4.75342C1.16879 3.34643 2.15592 2.14369 3.42217 1.29761C4.68843 0.451521 6.17709 0 7.70001 0C9.74217 0 11.7006 0.811097 13.1446 2.25513C14.5886 3.69916 15.4 5.65778 15.4 7.69995Z" fill="#F2F4F7"></path>
                                                                <path d="M3.94336 10.7979C4.72316 11.2974 5.62523 11.5727 6.55103 11.594C7.47683 11.6154 8.3906 11.3819 9.19263 10.919C9.99465 10.4561 10.6541 9.78166 11.0986 8.96929C11.5432 8.15692 11.7559 7.23787 11.7134 6.3128C12.061 6.06153 12.361 5.75038 12.5994 5.39385C12.2753 5.53742 11.9314 5.63153 11.5793 5.6729C11.9501 5.45108 12.2277 5.10192 12.3604 4.69073C12.0115 4.89728 11.6299 5.04317 11.2322 5.12188C10.9646 4.83702 10.6105 4.64831 10.2249 4.58501C9.83917 4.52171 9.4435 4.58716 9.09888 4.77154C8.75426 4.95592 8.47996 5.24881 8.3186 5.60479C8.15725 5.96077 8.11781 6.36008 8.2063 6.74077C7.45018 6.70542 6.80951 6.52196 6.17896 6.2022C5.5484 5.88244 4.99215 5.43359 4.54639 4.88482C4.31939 5.27587 4.24988 5.73879 4.35205 6.17925C4.45423 6.61972 4.72022 7.00473 5.09619 7.25591C4.81565 7.24665 4.54158 7.17037 4.29639 7.03374C4.29141 7.44768 4.43103 7.85039 4.69116 8.17242C4.9513 8.49444 5.31546 8.71575 5.72119 8.7979C5.46025 8.86845 5.18688 8.87849 4.92139 8.82769C5.03447 9.18055 5.25515 9.48938 5.55249 9.7105C5.84983 9.93162 6.20886 10.0541 6.57935 10.0608C6.21013 10.3512 5.78707 10.5657 5.33472 10.6922C4.88236 10.8187 4.40962 10.8547 3.94336 10.7979V10.7979Z" fill="#182D4C"></path>
                                                            </svg>
                                                        </a>
    
                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
    
                </table>
                </body>
                </html>
            """.trimIndent()
        }







}