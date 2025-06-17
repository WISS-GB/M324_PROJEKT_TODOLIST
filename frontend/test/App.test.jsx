import App from '../src/App';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';

beforeEach(() => {
  fetch.resetMocks();
});

test('renders ToDo Liste title', async () => {
  fetch.mockResponseOnce(JSON.stringify([
    { taskdescription: 'Item 1' },
    { taskdescription: 'Item 2' }
  ]));

  render(<App />);

  const item1 = await screen.findByText(/item 1/i);
  expect(item1).toBeInTheDocument();
  expect(item1).toBeVisible();

  const item2 = await screen.findByText(/item 2/i);
  expect(item2).toBeInTheDocument();
  expect(item2).toBeVisible();
});
