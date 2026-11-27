# Test Execution Summary

**Source:** Archived TestNG HTML report and the group's 16-case manual test workbook.  
**Execution evidence date:** 20 November 2025.

## Historical result

| Result | Count |
|---|---:|
| Passed | 7 |
| Failed | 9 |
| Skipped | 0 |
| Total | 16 |

### Passed
TC01, TC04, TC06, TC08, TC10, TC15, TC16.

### Failed and recorded observations

| Test case | Recorded observation |
|---|---|
| TC02 | Actual validation message did not include the trailing space in the expected text. |
| TC03 | The application returned an invalid-credentials message rather than the expected generic form error. |
| TC05 | The application returned an invalid-credentials message rather than the expected repeated-login-attempt warning. |
| TC07 | The actual registration success text differed from the expected text. |
| TC09 | The actual password-change confirmation included an exclamation mark absent from the expected text. |
| TC11 | Actual field-validation text differed from the expected text by punctuation. |
| TC12 | The password-reset flow stopped at an application/mailbox error before the remaining validation steps. |
| TC13 | The password-reset flow stopped at an application/mailbox error before the remaining validation steps. |
| TC14 | The actual ticket-booking confirmation differed from the expected text by capitalization. |

## Interpretation
The recorded failures are not all equivalent. Several are assertion-text mismatches, while TC12 and TC13 were blocked by the email/reset workflow. They should be triaged separately rather than summarized as nine confirmed product defects.

This table describes the archived coursework run only. The results have not been re-run against the current target.
