import { test, expect } from '@playwright/test';

// Login credentials
const loginUrl = 'https://dev.mymirakey.com/auth/login';
const username = 'arnob@resonian.com';
const password = 'Jaspershebin420';

// Locator for login page using XPath
const usernameXPath = 'xpath=//input[@name="email"]';
const passwordXPath = 'xpath=//input[@name="password"]';
const loginButtonXPath = 'xpath=//button[@class="css-r7scqu emmy3ya2"]';

// URL to be tested after login
const url = 'https://dev.mymirakey.com/products/directory/list';

test('Test login and navigate to a URL', async ({ page }) => {
    console.log('Starting login process...');

    // Step 1: Navigate to the login page
    await page.goto(loginUrl);

    // Step 2: Fill in the username and password
    await page.fill(usernameXPath, username);
    await page.fill(passwordXPath, password);

    // Step 3: Click the login button
    await page.click(loginButtonXPath);

    // Step 4: Ensure that login is successful by checking the URL
    await expect(page).toHaveURL('https://dev.mymirakey.com/');

    console.log('Login successful. Now navigating to the test URL...');

    // Step 5: Navigate to the specific URL to be tested
    const response = await page.goto(url, { timeout: 60000 });

    // Step 6: Check if the page loaded successfully (HTTP status code < 400)
    expect(response.status()).toBeLessThan(400);  // Success if status is between 200 and 399

    // Step 7: Pause the page so you can inspect it in headed mode
    await page.pause();

    // Log success
    console.log(`Successfully loadededddddddd the URL: ${url}`);
});
